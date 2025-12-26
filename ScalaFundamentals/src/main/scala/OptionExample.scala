
object OptionExample extends App {

  def getCustomerNameUsingId (id: Int) : String = {
    null
  }

  var customerName :Option[String] = Some("Abhay")

  customerName = Option(getCustomerNameUsingId(5))   // None

  println(s"cusotmer Name is : ${customerName.getOrElse("Not found")}")
}
