package fr.extia.store

import routes.StoreRoutes

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._

import scala.concurrent.ExecutionContext.global

object AppServer extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    (for {
      exitCode <- BlazeServerBuilder[IO](global)
        .bindHttp(port = 8080, host = "0.0.0.0")
        .withHttpApp(buildRoutes().orNotFound)
        .serve
    } yield exitCode).compile.lastOrError
  }

  private def buildRoutes() = {
    val storeRoutes = new StoreRoutes()
    storeRoutes.routes
  }
}
