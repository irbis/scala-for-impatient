import java.io.File
import java.util
import java.util.Scanner

// ######################## ex1 ##############################
val thingsToBuy = Map("Milk" -> 24.4, "Apples" -> 45.5, "Sugar" -> 34.3)
for ((t, p) <- thingsToBuy) yield (t, p - p * 0.1)

// ######################## ex2, ex4 ########################
val wordsCountMap = collection.mutable.SortedMap[String, Int]()
val in = new Scanner(new File("/home/irbis/Музыка/86 - A Kind Of Magic/Queen.txt"))
while (in.hasNext()) {
  val word = in.next()
  wordsCountMap(word) = wordsCountMap.getOrElse(word, 0) + 1
}
in.close()
for ((w, c) <- wordsCountMap)
  println(s"Count of a word $w is $c")

// ######################## ex3 ########################
var immutableWordsCountMap = Map[String, Int]()
val ex3In = new Scanner(new File("/home/irbis/Музыка/86 - A Kind Of Magic/Queen.txt"))
while (ex3In.hasNext()) {
  val word = ex3In.next()
  val count = if (!immutableWordsCountMap.contains(word)) 1 else immutableWordsCountMap(word) + 1
  immutableWordsCountMap = immutableWordsCountMap + (word -> count)
}

immutableWordsCountMap

in.close()
for ((w, c) <- immutableWordsCountMap)
  println(s"Count of a word $w is $c")

// ######################## ex5 ########################
import collection.JavaConverters._
val wordsCountTreeMap: collection.mutable.Map[String, Int] =
  new util.TreeMap[String, Int]().asScala
val treeIn = new Scanner(new File("/home/irbis/Музыка/86 - A Kind Of Magic/Queen.txt"))
while (treeIn.hasNext()) {
  val word = treeIn.next()
  wordsCountTreeMap(word) = wordsCountTreeMap.getOrElse(word, 0) + 1
}
treeIn.close()
for ((w, c) <- wordsCountTreeMap)
  println(s"Count of a word $w is $c")

// ######################## ex6 ########################
var weekDays = collection.mutable.LinkedHashMap(
  java.util.Calendar.MONDAY -> "Monday",
  java.util.Calendar.TUESDAY -> "Tuesday",
  java.util.Calendar.WEDNESDAY -> "Wednesday",
  java.util.Calendar.THURSDAY -> "Thursday",
  java.util.Calendar.FRIDAY -> "Friday",
  java.util.Calendar.SATURDAY -> "Saturday",
  java.util.Calendar.SUNDAY -> "Sunday" )

for ((_, d) <- weekDays) yield d

// ######################## ex7 ########################
import collection.JavaConverters._
val props: collection.Map[String, String] = System.getProperties.asScala
val maxPropLen = props.keys.maxBy(_.length).length
for ((k, v) <- props) printf(s"%-${maxPropLen}s|%s\n", k, v)

// ######################## ex8 ########################
def minmax(values: Array[Int]) = (values.min, values.max)
minmax(Array(1, 2, 10, -1))

// ######################## ex9 ########################
def lteqgt(values: Array[Int], v: Int) = {
  var lessCount = 0
  var equalsCount = 0
  var moreCount = 0

  for (i <- values) {
    if (i < v) lessCount += 1
    else if (v == i) equalsCount += 1
    else moreCount += 1
  }

  (lessCount, equalsCount, moreCount)
}

def lteqgt1(values: Array[Int], v: Int) = {
  var counts = (0, 0, 0)

  for (i <- values) {
    if (i < v) counts = (counts._1 + 1, counts._2, counts._3)
    else if (v == i) counts = (counts._1, counts._2 + 1, counts._3)
    else counts = (counts._1, counts._2, counts._3 + 1)
  }

  counts
}

def lteqgt2(values: Array[Int], v: Int) =
  (
    values.count(_ < v),
    values.count(_ == v),
    values.count(_ > v)
  )


lteqgt(Array(-4, -3, -2, -1, 0, 0, 0, 1, 2, 3, 4, 5), 0)
lteqgt1(Array(-4, -3, -2, -1, 0, 0, 0, 1, 2, 3, 4, 5), 0)
lteqgt2(Array(-4, -3, -2, -1, 0, 0, 0, 1, 2, 3, 4, 5), 0)

// ######################## ex10 ########################
"Hello".zip("World")