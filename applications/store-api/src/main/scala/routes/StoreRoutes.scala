package fr.extia.store
package routes

import input.AddProductInput

import cats.effect.{Concurrent, ContextShift, IO, Timer}
import cats.syntax.semigroupk._
import org.http4s.HttpRoutes
import sttp.model.StatusCode.Created
import sttp.tapir.Tapir
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.json.circe.TapirJsonCirce
import sttp.tapir.openapi.circe.yaml._
import sttp.tapir.server.http4s.Http4sServerInterpreter
import sttp.tapir.swagger.http4s.SwaggerHttp4s

final class StoreRoutes()(implicit
    concurrent: Concurrent[IO],
    cs: ContextShift[IO],
    timer: Timer[IO]
) extends Tapir
    with TapirJsonCirce {

  private val addProduct = endpoint
    .in("product")
    .post
    .in(jsonBody[AddProductInput])
    .out(statusCode(Created) and jsonBody[String])
    .description("Add product to the store")
    .serverLogic[IO](input => IO.pure(input.name).map(Right(_)))

  private val endpoints = List(addProduct)

  private val swaggerRoute =
    new SwaggerHttp4s(
      OpenAPIDocsInterpreter()
        .serverEndpointsToOpenAPI[IO](endpoints, "Store", "0.1")
        .toYaml,
      List("swagger")
    ).routes

  val routes: HttpRoutes[IO] =
    Http4sServerInterpreter().toRoutes(endpoints) <+> swaggerRoute
}
