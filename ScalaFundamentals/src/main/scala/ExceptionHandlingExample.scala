import scala.io.StdIn

@main
def exceptionExample(): Unit = {
  println("Input a number :")
  val input = StdIn.readLine()
  try{
    val number = input.toInt
  }
  catch{
    case e: NumberFormatException => {
      println("Please enter number!!!! Exception occured " + e.getMessage)
      throw(new Exception("custom exception message")) 
      //e.printStackTrace()
    }
  }
  finally {
    println("Placeholder for finally block")
  }
  println ("Completed execution")
}