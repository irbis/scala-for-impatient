def signum(x: Int) = {
  if ( x == 1) 0
  else if (x > 1) 1
  else -1
}

signum(10)
signum(-10)
signum(0)

val emptyBlock = {}

for ( i <- (0 to 10).reverse) println(i)
for ( i <- Seq(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)) println(i)

def countdown(n: Int) = {
  for ( i <- (0 to n).reverse) println(i)
}

countdown(5)

var r: Long = 1
for (c <- "Hello") r = r * c
println(r)

def product(s: String) = {
  var r: Long = 1L
  for (c <- "Hello") r = r * c
  r
}

def productRecursive(s: String): Long = {
  if (s.length == 0) 1L
  else s.head * productRecursive(s.tail)
}

productRecursive("Hello")
