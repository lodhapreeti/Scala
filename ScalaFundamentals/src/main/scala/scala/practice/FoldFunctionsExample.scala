package scala.practice

@main
def foldFunctionsExample(): Unit = {
  val numbers = List (2,4,6,9, -7, 3,-8, 4, -1)
  val newNumbers = numbers.foldLeft(0)(_ - _)
  println(newNumbers)
  val newNumbers1 = numbers.foldRight(0)(_ - _)
    //Evaluation for foldRight :  2-(4-(6-(3-(4-0)))))
  println(newNumbers1)

  val clients = List ("Mark", "Mary","Alicia","Donna")
  println(clients)
  val result = clients.foldLeft("")((acc,word) => acc + "," + word +" .. " )
  println(result)
  // Attempt to reverse
  val reverse = clients.foldLeft("")((acc,word) => word + "," + acc )
  println(reverse)

  // Reverse of Number list
  println(numbers)
  val revNumbers = numbers.foldLeft(List[Int]())((acc,word)=> word ::  acc)
  println(revNumbers)

  println()
  println(numbers)
  val result4 = numbers.foldRight(List[Int]())((acc, word) => acc :: word)
  println(result4)
  val resultRev = numbers.foldRight(List[Int]())((wordVal, acc) => acc ++ List(wordVal)  )
  println(resultRev)

  reduceTrial(numbers)
}
def reduceTrial(numbers: List[Int]): Unit = {
  println("in reduce trial")
  val sum= numbers.reduce(_ + _ )
  println(sum)

  val max = numbers.reduce(_ max _)
  println(s"Max is $max and min is ${numbers.reduce(_ min _ )}")
}