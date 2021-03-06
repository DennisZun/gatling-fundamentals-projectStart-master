package simulations

//aantekening 13 december 2018 ; dennis van zundert
//in de Udemy cursus werd deze .scala file niet gemaakt, maar werd een aanapssing gedaan in CustomFeeder.scala,
//maar ik wilde die file ook behouden om eventueel later op terug te kunnen vallen,
//daarom deze gemaakt

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class CustomFeederWithTemplate extends BaseSimulation {

  var idNumbers = (11 to 20).iterator
  val rnd = new Random()
  val now = LocalDate.now()
  val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  def getRandomDate(startDate: LocalDate, random: Random): String = {
    startDate.minusDays(random.nextInt(30)).format(pattern)
  }


  val customFeeder = Iterator.continually(Map(
    "gameId" -> idNumbers.next(),
    "name" -> ("Game-" + randomString(5)),
    "releaseDate" -> getRandomDate(now, rnd),
    "reviewScore" -> rnd.nextInt(100),
    "category" -> ("Category-" + randomString(6)),
    "rating" -> ("Rating-" + randomString(4))
  ))

  def postNewGame() = {
    repeat(5) {
      feed(customFeeder)
        .exec(http("Post New Game")
          .post("videogames/")
          .body(ElFileBody("NewGameTemplate.json")).asJSON
          .check(status.is(200)))
        .pause(1)
    }
  }

  val scn = scenario("Video Game DB")
    .exec(postNewGame())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
