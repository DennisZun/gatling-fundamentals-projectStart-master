package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseSimulation extends Simulation{

  val httpConf = http
    .baseURL("http://localhost:8080/app/")
    .header("Accept","Application/json")
//    .proxy(Proxy("localhost", 88888).httpsPort(8888)) - was optioneel, zie college 17

}
