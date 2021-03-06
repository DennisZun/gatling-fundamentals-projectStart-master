package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class RuntimeParameters extends BaseSimulation {

  def getAllVideoGames() = {
    exec(
      http("Get All Video Games")
        .get("videogames")
        .check(status is(200))
    )
  }

  val scn = scenario("Video Game DB")
    .forever() {
      exec(getAllVideoGames())
    }

  setUp(
    scn.inject(
      nothingFor(5 seconds),
      rampUsers(1) over (1 second)
    )
  ).protocols(httpConf).maxDuration(20 seconds)

}
