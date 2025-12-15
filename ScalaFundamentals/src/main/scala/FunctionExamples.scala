@main
def functionExamples(): Unit = {
  functionWithOneIntParam(10)
  val list = List ("Anna","Bob","Taylor","Pierre")
  //functionWithList(list)
  //functionWithDefaultParam(list)
  //functionWithDefaultParamVariation(i=5,list)
  //functionWithDefaultParamVariation(strings = list)
  //functionWithDefaultParamVariation(list) -- this does not work
  //println(functionWithReturn(77))
  //println(s"Calling function to double ${functionWithShorthandReturn(8)}")
  //println(s"Multiple with one param ${multiply(21)}")
  //print(s"Multiple with 2 params ${multiply(21,3)}")
  //hello("Maria")
  //hello(Set("Bob", "Kimmy", "Jimmy", "Torres"))
  functionWithVariableParams("meena","seena","rossy","aaa")
  println("")
  val names = List("a","b","c","d")
  functionWithVariableParams("qq","44","ff")
  functionWithVariableParams(names:_*)  // Splat Operator

  functionWithAnotherFunc()
  //listVal() // Does not work
}

def functionWithAnotherFunc(): Unit = {
  def listVal(i:Int) = println(i)
  //def listVal(s:String)= println(s"Str $s") // Scala does not support overloaded local functions 
  val values = List (1,2,3,4)
  for(s <- values)
    listVal(s)
}

def functionWithVariableParams(str: String*): Unit = {
  var i=0
  for (s <- str) {
    println(s"$i param is $s")
    i+=1
  }
}

def functionWithDefaultParam(strings: List[String], i: Int =3): Unit = {
  println(s"Number passed is $i")
  println(strings)
}

def functionWithDefaultParamVariation(i: Int =3, strings: List[String]): Unit = {
  println(s"Number passed is $i")
  print(strings)
}

def functionWithOneIntParam(number :Int ): Unit = {
  println(s"received number : $number")
}

def functionWithList(clients: List[String]): Unit = {
  for (client <- clients)
    println(s"Hii $client")
}
def functionWithReturn(i: Int) :Int = {
  i*2 // return keyword is not mandatory
}

def functionWithShorthandReturn(i:Int) = i*2

def multiply(number:Int) = number*2
def multiply(number:Int, multiplier:Int) = number*multiplier

def hello(name :String ) = println(s"Hii $name")
def hello(iter : Iterable[String]): Unit = {
  for(s<-iter)
    println(s"Hii Elt $s")
}