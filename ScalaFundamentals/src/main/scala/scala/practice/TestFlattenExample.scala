package scala.practice

object TestFlattenExample extends App {

  val listOfList = List(List("string", 123), List("string2", 234))
  println(listOfList)
  println(listOfList.flatten)

  /*val a = (1 to 10)
  println(a)
  val b = a.map(x => (1 to x).toList).flatten
  println(b)
*/

  val clientInfo = Map(1 -> ClientInfo1("Mark", "m@a.com"), 2 -> ClientInfo1("Tony", "t@a.com"), 3 -> ClientInfo1("Maria", "m@a.com"), 4 -> ClientInfo1("Alicia", "a@a.com"))
  /*val clientInfo = Map(1 -> List("Mark", "m@a.com"),
    2 -> List("Tony", "t@a.com"),
    3 -> List("Maria", "m@a.com"),
    4 -> List("Alicia", "a@a.com"))
*/
  println(clientInfo)
  println(clientInfo.map(x=> {
    List(x._1) ++ List(x._2.name , x._2.email)
  }).flatten)

  println(clientInfo.flatMap(x => {
    List(x._1) ++ List(x._2.name, x._2.email)
  }))

  val yieldValues = for (i <- 10 to 100) yield {
    if(i%3 == 0) i  else 0
  }

  val yieldValues1 = for {
    i <- 10 to 100
    if(i % 3 ==0)
  } yield i

  val x = for(i<- 10 to 100; if (i%3==0))yield i

  val y = for{i<- 10 to 100 if (i%3==0)} yield i
  println(yieldValues.filter(_ > 0))
  println(yieldValues1)
  println(x)
  println(y)

}
