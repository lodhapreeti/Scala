object NestedOption extends App {

  val a : Option[Option[String]] = Some(Some("Abhay"))
  println(a)

  val b = a.flatten
  println(b)
}
