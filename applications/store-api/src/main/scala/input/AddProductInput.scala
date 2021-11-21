package fr.extia.store
package input

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import sttp.tapir.Schema

final case class AddProductInput(name: String)

object AddProductInput {
  implicit val codec: Codec[AddProductInput] = deriveCodec
  implicit val schema: Schema[AddProductInput] = Schema.derived
}
