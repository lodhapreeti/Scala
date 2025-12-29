package scala.practice

@main
def zipExamples(): Unit = {
  val l1 = List(1,2,4,5,3)
  val l2 = List("aaa", "bbb","ccc","ddd","xxxx","yyyyy","hhhh")
  val zipList1 = l1.zip(l2)
  println(zipList1)
  val zipList2 = l1.zipAll(l2,"zzz","ppp") 
  println(zipList2)
  println(l1.zipWithIndex)
  println(l2.zipWithIndex)
  println(l2.zip(LazyList.from(100)))

  val fibonacci = fibs(0, 1)
  // Accessing elements forces their computation:
  println(fibonacci.take(3).toList)
  println(l1.take(2))

  val sumVal = sum(10)
  println(sumVal.take(10).toList)
}
def sum (start : Int) : LazyList[Int]={
    //start #:: sum(start+1) 
  LazyList.cons(start,sum(start+1))
}
def fibs(a: BigInt, b: BigInt): LazyList[BigInt] =
  a #:: fibs(b, a + b) // The tail 'fibs(b, a + b)' is lazy