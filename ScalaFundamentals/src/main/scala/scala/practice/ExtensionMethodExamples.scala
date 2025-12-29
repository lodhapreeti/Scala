package scala.practice
import StringUtils1.*

@main
def extensionMethodExamples() :Unit = {
  val greeting = "hello"
  println(greeting.shout) // Output: HELLO!
  println(greeting.exclamation(3)) // Output: hello!!!
  println(greeting.question())
  val number = 10
  println(number.add(20))
  println(number.multiply(2))
}

// Define the extension method within an object to control scope
object StringUtils1 {
  extension (s: String) {
    def shout: String = s.toUpperCase() + "!"
    def exclamation(count: Int): String = s + "!" * count
    def question():String = "What " + s +"?"
  }
  extension (i:Int) {
    def multiply(multiplier:Int) :Int = i*multiplier
    def add (number : Int) : Int =  i + number
  }
}



