package scala.practice

@main
def typeClassExample(): Unit = {
  println(getGenericMessage(1))
  println(getGenericMessage("abcd"))
  //printGeneric(30.5)
}

def getGenericMessage[A](a:A)(using s: TestTypeClass[A]): String = s.getMessage(a)

trait TestTypeClass[A] {
  def getMessage(a:A):String = s"Value is of type ${a.getClass} and actual value : $a"
}

given TestTypeClass[Int] with
  override def getMessage(i:Int) = s"Value is  ${i.getClass} :  $i"

given TestTypeClass[String] with
  override def getMessage(str:String) = s"Value is ${str.getClass}: $str "
