import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

@main
def collectionExamples(): Unit = {
  // listExamples()
  //arrayExamples()
  //arraybufferExamples()
  setExamples()
}

def setExamples(): Unit = {
  val set1 = Set(1,2)
  println(set1)
  val set2 = mutable.HashSet("11",22,"44",53)
  print(set2)
  set2.add("33")
  set2 += 3
  println(set2)
  set2 -= ("11",44)
  println(set2)
}
def arraybufferExamples(): Unit = {
  val arrBuff = ArrayBuffer(1,2,3,4,5)
  println(arrBuff)
  arrBuff.remove(2)
  println(arrBuff)
  arrBuff.addOne(3)
  println(arrBuff)
  arrBuff --= List(1,2)
  println(arrBuff)
  arrBuff.remove(2,1)
  println(arrBuff)
  arrBuff.addAll(List(1,2,3))
  println(arrBuff)
  arrBuff.insert(0,1)
  println(arrBuff)
  arrBuff.insertAll(1,List(2,3))
  println(arrBuff)
  arrBuff.remove(5,3)
  println(arrBuff)
}
def arrayExamples(): Unit = {
  val arrayEx =  Array("as",1, true)
  val arrayEx1 = Array( 6, false)

  println(arrayEx)  // Prints Object address
  arrayEx.foreach(println) // prints each element on a new line
  println(arrayEx.mkString) // concatenates each element, but no separated added
  println(arrayEx.toList) // better output as a list

  // Mutating Arrays -- Can only change elements, not the size
  arrayEx(1)=7
  println(arrayEx.toList)
  // Can prepend/ append to array as below
  val arrayNew = "222" :+ arrayEx
  println(arrayNew.toList)  // Need to understand this better @todo => the ':+' changes the whole meaning of expression..
  val arrayNew1 = 2 +: arrayEx
  println(arrayNew1.toList)
  val arrayNew2 = "222" +: arrayEx
  println(arrayNew2.toList)
  val arrayNew3 = "222" +: arrayEx :+  "77"
  print(arrayNew3.toList)
  // Concatenation of arrays 
  val concatArr = arrayEx ++  arrayEx1
  println (concatArr.toList)    // TODO:  need to understand this better. Why it displays List(222, as, 7, true, 77)List(as, 7, true, 6, false)
}

def listExamples(): Unit = {
  //Creation of Lists
  // Empty Lists
  val a = List()
  var b = Nil
  println(a)
  println(b)

  // List with same datatype elements
  val list1 = List(1, 2, 5, 6, 2, 3, -10)
  println(list1)
  //Diffnt datatypes in list
  val list2 = List("string", 1, true)
  println(list2)
  // Limiting datatype to specific datatype
  val list3 = List[Float](1, 2, 32.44, 55.12, 78.45, 679)
  println(list3)

  // List of Lists
  val matrix = List(
    List(2, 3, 1, "yyy", 77),
    List(4, 7, 2, 1),
    Nil,
    List("776"),
    List[Int](7, 8, 999)
  )
  println(matrix)
  //Accessing Elements of list
  println(matrix(0)(3))
  println(matrix(4)(2))
  println(matrix.head)
  println(list3.tail) // all except the first element
  println(matrix.tail)
  // Length
  println(b.length)
  println(matrix.length)
  println(list3.length)
  println(matrix(1).length)
  println(matrix.tail.length)
}