package scala.practice

@main
def partialFunctionsExample(): Unit = {
  val isEven : PartialFunction[Int,String] = {
    case x if (x%2==0)=> s" $x is even"
  }
  for(i<- 1 to 20) {
    if(isEven.isDefinedAt(i))
      println(s"Is Even : $i")
      println(isEven(i))
    else
      println(s"Is Not Even $i")
  }
  // Apply or Else method trial
  val numberList = List (1,2,3,4,5,6,8)
  println(numberList.map(isEven.applyOrElse(_, _+ " is odd")))

  // Collect
  println(numberList.collect(isEven))

  println()
  // lift
  for (i <- numberList)
    val liftedIsEven = isEven.lift  // Helps to give in Some + None format 
    liftedIsEven(i) match {
      case Some(value) => println(value)
      case None => println(s"Some Issue with $i")
    }
    

}

//def testEven(int:Int):PartialFunction[Int]
