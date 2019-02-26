# Eq

In scala we can compare two values with one another.

```tut
4 == 4
"Hello" == "world"
```

However, the problem with this is that it isn't type safe.
```tut
"Hello" == 4
```

Gross. How can we fix this? `Eq` typeclass to the rescue!
 
```tut:silent
import cats._
import cats.implicits._
import sandbox.models._
```

```tut
implicit val eqCat: Eq[Cat] = Eq.instance[Cat]((x, y) => (x.sound === y.sound) && (x.fur === y.fur))

val cat1 = Cat("Meow", "Brown")
val cat2 = Cat("Meow", "Brown")

println(cat1 === cat2)
println(cat1 =!= cat2)

val cat3 = Cat("Woof", "Blue")

println(cat1 === cat3)
println(cat1 =!= cat3)
```
