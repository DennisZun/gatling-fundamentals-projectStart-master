package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseSimulation extends Simulation{

  val httpConf = http
    .baseURL("http://localhost:8080/app/")
    .header("Accept","Application/json")
    .proxy(Proxy("localhost", 8089).httpsPort(8089)) //- was optioneel, zie college 17

}
