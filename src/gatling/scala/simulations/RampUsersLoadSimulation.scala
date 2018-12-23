package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt


class RampUsersLoadSimulation extends BaseSimulation{

  def getAllVideoGames() = {
    exec(
      http("Get all video games")
        .get("videogames")
        .check(status.is(200))
    )


  }

  def getSpecificVideoGame() = {
    exec(
      http("get Specific Video Game")
        .get("videogames/2")
        .check(status.is(200))
    )
  }

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGame())
    .pause(5)
    .exec(getAllVideoGames())

  setUp(
    scn.inject(
      nothingFor(5 seconds),
//      constantUsersPerSec(5) during(10) // 10 seconden lang elke seconde 5 nieuwe users
      rampUsersPerSec(1) to (5) during (20) // verdeeld over 20 secodenden van 1 naar 5 nwe users / sec. (8e sec. 2; 9e sec.3)
         ).protocols(httpConf.inferHtmlResources())
  )

//  setUp(
//    scn.inject(atOnceUsers(1))
//  ).protocols(httpConf)

}
