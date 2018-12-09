package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

import baseConfig.BaseSimulation

class AddPauseTime extends BaseSimulation {

  val scn = scenario("Video Game DB")

    .exec(http("Get All Video Games - 1st call")
    .get("videogames"))
    .pause(5)

    .exec(http("Get Specific game")
    .get("videogames/1"))
    .pause(1, 20)

    .exec(http("Get all Video Games - 2nd call")
    .get("videogames"))
    .pause(3000.milliseconds)

  setUp(
    scn.inject(atOnceUsers(1))
    ).protocols(httpConf)

}
