package sandbox.cats.typeclasses

import cats._
import cats.implicits._
import sandbox.models.Cat

object SemigroupApp extends App {

    println(Semigroup[Int].combine(1, 2))

    println(1 |+| 2)

    println(List(1, 2, 3) |+| List(4, 5, 6))

    println(Semigroup[Int => Int].combine(_ + 1, _ * 10).apply(6))

    val aMap = Map("foo" → Map("bar" → 5))
    val anotherMap = Map("foo" → Map("bar" → 6))
    val combinedMap = Semigroup[Map[String, Map[String, Int]]].combine(aMap, anotherMap)

    println((aMap |+| anotherMap).get("foo"))

    implicit val catSemigrop = Semigroup.instance[Cat]((x, y) => Cat(x.sound |+| y.sound, x.fur |+| y.fur))

    val cat1 = Cat("Meow", "Brown")
    val cat2 = Cat("Woof", "Blue")

    println(cat1 |+| cat2)

}
