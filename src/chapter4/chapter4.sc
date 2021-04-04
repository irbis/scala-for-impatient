// page 50
// Maps
val immutableMapScores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

val mutableMapScores = collection.mutable.Map[String, Int]("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

val emptyMapScores = collection.mutable.HashMap[String, Int]()

val immutableMapFromPair = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

val bobsScore = immutableMapScores("Bob")

val bobsScore = if (mutableMapScores.contains("Bob")) mutableMapScores("Bob") else 0

val bobsScore = emptyMapScores.getOrElse("Bob", 0)

val optionBobsScore = immutableMapFromPair.get("Bob")

mutableMapScores("Bob") = 10
mutableMapScores("Fred") = 7
mutableMapScores += ("Bob" -> 10, "Fred" -> 7)
mutableMapScores -= "Alice"

val newImmutableMapScores = immutableMapScores + ("Bob" -> 10, "Fred" -> 7)
newImmutableMapScores - "Alice"

for ((k, v) <- newImmutableMapScores)
  println("Key is: " + k + ", Value is: " + v)

for (v <- immutableMapFromPair.values) println(v)

for ((k, v) <- mutableMapScores) yield (v, k)

val sortedTreeMap = collection.immutable.SortedMap(
  "Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)

// work with java structures
import collection.JavaConverters._
import java.util
val fromJavaTreeMap: collection.mutable.Map[String, Int] =
  new util.TreeMap[String, Int]().asScala

val props: collection.Map[String, String] = System.getProperties.asScala

// Tuples
(1, 3.14, "Fred")
val t = (1, 3.14, "Fred")
t._1
t._2
t._3

// pattern matching
val (first, second, third) = t
first
second
third

val (first, second, _) = t // _ to skip value

// zipping
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

for ((s, n) <- pairs) println(s * n)
symbols.zip(counts).toMap