object NestedSeq extends App {

  val a = for {
    i <- (1 to 10)
    j <- (1 to 10)
    if (i % 2 == 0 && j % 3 == 0)
  }
  yield ((i, j))

  val a2 = for (i <- (1 to 10);
                j <- (1 to 10);
                if (i % 2 == 0 && j % 3 == 0)
  )
  yield ((i, j))

  // (1,2,3,4,5,6,7,8,9,10)

  println(a)
  println(a2)


  //Prob 1 : Convert this list as per below
  //First element 1 expands to 1
  //Second element 2 expands to 1, 2
  //..
  //
  //final output 1 : 1, 1, 2, 1, 2, 3,   ...... 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

  val b = a.flatMap(x => {
    (1 to x._1)
  })

  println(b)
}
