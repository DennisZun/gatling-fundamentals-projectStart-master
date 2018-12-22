package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt


class BasicLoadSimulation extends BaseSimulation{

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
      atOnceUsers(5),
      rampUsers(10) over (10)
         ).protocols(httpConf.inferHtmlResources())
  )

}
