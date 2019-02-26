# Eq

In scala we can compare two values with one another.

```scala
scala> 4 == 4
res0: Boolean = true

scala> "Hello" == "world"
res1: Boolean = false
```

However, the problem with this is that it isn't type safe.
```scala
scala> "Hello" == 4
res2: Boolean = false
```

Gross. How can we fix this? `Eq` typeclass to the rescue!
 
```scala
import cats._
import cats.implicits._
import sandbox.models._
```

```scala
scala> implicit val eqCat: Eq[Cat] = Eq.instance[Cat]((x, y) => (x.sound === y.sound) && (x.fur === y.fur))
eqCat: cats.Eq[sandbox.models.Cat] = cats.kernel.Eq$$anon$106@670c31ea

scala> val cat1 = Cat("Meow", "Brown")
cat1: sandbox.models.Cat = Cat(Meow,Brown)

scala> val cat2 = Cat("Meow", "Brown")
cat2: sandbox.models.Cat = Cat(Meow,Brown)

scala> println(cat1 === cat2)
true

scala> println(cat1 =!= cat2)
false

scala> val cat3 = Cat("Woof", "Blue")
cat3: sandbox.models.Cat = Cat(Woof,Blue)

scala> println(cat1 === cat3)
false

scala> println(cat1 =!= cat3)
true
```
