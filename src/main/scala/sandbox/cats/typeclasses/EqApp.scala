package sandbox.cats.typeclasses

import cats._
import cats.implicits._
import sandbox.models.Cat

object EqApp extends App {

    implicit val eqCat: Eq[Cat] = Eq.instance[Cat]((x, y) => (x.sound === y.sound) && (x.fur === y.fur))

    val cat1 = Cat("Meow", "Brown")
    val cat2 = Cat("Meow", "Brown")

    println(cat1 === cat2)
    println(cat1 =!= cat2)

    val cat3 = Cat("Woof", "Blue")

    println(cat1 === cat3)
    println(cat1 =!= cat3)

}
