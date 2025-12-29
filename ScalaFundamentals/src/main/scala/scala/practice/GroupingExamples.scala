package scala.practice

@main
def groupingExamples(): Unit = {
  val list = List("")
  val clientList = List(
    ClientInfo(1, "Mary", "m@m.com", 2000),
    ClientInfo(2, "Tony", "t@m.com", 2000),
    ClientInfo(3, "Mark", "m1@m.com", 3000),
    ClientInfo(4, "Alissa", "a@m.com", 1500),
    ClientInfo(5, "Maria", "m2@m.com", 2000))

  println(s"Client list : $clientList")
  val orderedBySal = clientList.groupBy(_.salary)
  println(s"Ordered Client List by Salary : $orderedBySal")
  println(clientList.groupMap(_.salary)(_.name))
  //val orderedByName = clientList.groupBy(_.name)
  //println(s"Ordered Client List by Name : $orderedByName")

  /*val fruits = List("apple", "apple", "orange", "pear", "pear", "pear", "grapes")
  println(fruits)
  println(fruits.groupBy(identity))*/
}

case class ClientInfo(id: Int, name: String, email: String, salary: Int)