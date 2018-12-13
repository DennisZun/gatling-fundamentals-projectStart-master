package simulations

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import baseConfig.BaseSimulation

import scala.util.Random

class CustomFeeder extends BaseSimulation {

  var idNumbers = (11 to 20).iterator
  val rnd = new Random()
  val now = LocalDate.now()
  val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  def getRandomDate(startDate: LocalDate, random: Random):String = {
    startDate.minusDays(random.nextInt(30)).format(pattern)
  }


  val customFeeder = Iterator.continually(Map(
    "gameId" -> idNumbers.next(),
    "name" -> ("Game-" + randomString(5)),
    "releaseDate" -> getRandomDate(now, rnd),
    "reviewScore" -> rnd.nextInt(100),
    "category" -> ("Category" + randomString(6)),
    "rating" -> ("Rating" + randomString(4))
  ))

  def postNewGame() = {
    repeat(5) {
      feed(customFeeder)
        .exec(http("Post New Game")
        .post("videogames/")
        .body(StringBody(
          "{" +
          "\n\t\"id\": ${gameId}," +
            "\n\t\"name\": \"${name}\"," +
            "\n\t\"releaseDate\": \"${releaseDate}\"," +
            "\n\t\"reviewScore\": ${reviewScore}," +
            "\n\t\"category\": \"${category}\"," +
            "\n\t\"rating\": \"${rating}\",")
        ).asJSON
            .check(status.is(200)))
        .pause(1)
    }
  }

  val scn = scenario("Video Game DB")
    .exec(postNewGame())

  setUP(scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
