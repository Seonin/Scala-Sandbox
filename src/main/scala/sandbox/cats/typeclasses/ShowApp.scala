package sandbox.cats.typeclasses

import cats._
import cats.implicits._
import sandbox.models.Cat

object ShowApp extends App {

    implicit val showCat: Show[Cat] = Show.show(cat => s"'${cat.sound}' said the ${cat.fur} cat")

    val cat = Cat("Meow", "Brown")

    println(cat.show)

}
