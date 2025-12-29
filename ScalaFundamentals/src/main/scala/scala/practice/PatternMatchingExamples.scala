package scala.practice

import scala.util.Random

@main
def patternMatchingExamples(): Unit = {
  val notification:Notification = getNotification()
  println(notification)

  //Class Match :
  // In below - note the Constructor call is super imp to find out the type of the class
  notification match {
    case SMSNotification(_,_) => println(s"SMS Notification : ${notification.sendNotification()}")
    case EMailNotification(_,_) => println(s"EMAIL Notification : ${notification.sendNotification()}")
    case _ => println("What is this type?? ")
  }

  // Match on type only
  println(matchClass(notification))
  println("==============")

  // Structured String Pattern Match :
  val structStr = getPattern()
  println(structStr) // Successful example  RandomName is 6 years old
  structStr match
    case s"$name is $age years old" => println(s"Name : $name Age : $age")
    case _ => println("Pattern not matched ")



  val input: String = "Alicia is 60 years old"

  val (name, age) = input match
    case s"$name is $age years old" => (name, age)

  println()
  println(s"$name's age is $age'")
}

def matchClass (notfn :Notification) :String = notfn match {
  case p: SMSNotification =>  "SMS"
  case m: EMailNotification => "Email"
  case _ => "What is this"
}

/*
object Age:
  def unapply(s: String): Option[Int] = s.toIntOption
*/

trait Notification {
  def sendNotification(): Unit
}


case class SMSNotification(phoneNumber:String, message:String) extends  Notification:
   def sendNotification():Unit = println(s"Sending SMS $message to phone number $phoneNumber ")


case class EMailNotification(emailId:String, message:String) extends  Notification:
  def sendNotification():Unit = println(s"Sending Email '$message'  to Email ID  $emailId ")

def getNotification(): Notification = {
  val rand =  Random.nextInt(10)
  if (rand%2 ==0 )
    SMSNotification("1212" ,"Hii -Sending you a SMS")
  else
    EMailNotification("a@a.com", "Hii - Sending you this email")
}

def getPattern():String ={
  val rand = Random.nextInt(20)
  if (rand%2 ==0)
    return s"RandomName is $rand years old"
  else
    return s"Random String $rand"
}


