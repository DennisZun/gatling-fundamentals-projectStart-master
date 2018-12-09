package simulations

import baseConfig.BaseSimulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CodeReuseWithObjects extends BaseSimulation {

  //  val scn = scenario("Video Game DB")
  //
  //    .exec(http("Get all Video Games")
  //      .get("videogames")
  //      .check(status.is(200)))
  //
  //    .exec(http("Get Specific Game")
  //      .get("videogames/1")
  //      .check(status.in(200 to 210)))
  //
  //    .exec(http("Get all Video Games")
  //      .get("videogames")
  //      .check(status.not(200)))

  def getAllVideoGames() = {
    repeat(3) {
      exec(http("Get all Video Games")
        .get("videogames")
        .check(status.is(200)))

    }
  }

  def getSpecificVideoGems() = {
    repeat(5){
      exec(http("Get Specific Game")
        .get("videogames/1")
        .check(status.in(200 to 210)))
    }
  }

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGems())
    .pause(5)
    .exec(getAllVideoGames())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
