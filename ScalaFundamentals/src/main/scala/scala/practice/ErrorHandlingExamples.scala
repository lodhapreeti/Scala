package scala.practice

import scala.io.StdIn
import scala.util.{Success, Try,Failure}

object ErrorHandlingExamples extends App {
  //Using Try, Success, Failure
  print("Enter a number : ")
  val input =  StdIn.readLine()
  val result:Try[Int] = processInputUsingTry(input)
  result match {
    case Success(result) => println(s"Result is $result")
    case Failure(exception) => println(s"Exception occured ${exception.getMessage()}")
  }

  println("===== Next Processing =====")


  //Using Option
  val result1 :Option[Int] = processInputUsingOption(input)
  result1 match {
    case Some(i) => println(s"Result received : $i")
    case None => println("Error Processing Result")
  }

  println("===== Next Processing =====")
  val result3 = processInputUsingEither(input)
  result3 match {
    case Right(value) => println(s"Received Result $value")
    case Left(exception: Exception) => println(s"Received Error ${exception.getMessage}")
  }


}

def processInputUsingTry(input: String): Try[Int] = Try{
  input.toInt
}

def processInputUsingEither(input:String): Either[Exception,Int] = {
   try {
    Right(input.toInt)
  }
  catch {
    case exception: Exception => Left(exception)
  }
}

def processInputUsingOption(input:String) : Option[Int] = {
  try{
    Some(input.toInt)
  }
  catch {
    case exception: Exception => None
  }
}


