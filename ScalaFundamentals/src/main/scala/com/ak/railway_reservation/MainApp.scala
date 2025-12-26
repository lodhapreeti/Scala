package com.ak.railway_reservation

/** Prerequisites to run the program :
 *
 * Required Environment variables :
 * DB_HOST
 * DB_NAME
 * DB_PASSWORD
 * DB_USER
 * DB_PORT
 */
object MainApp {
  def main(args: Array[String]): Unit = {

    val repo = new UserRepository()

    repo.insertUser(User(1, "Alice"))
    repo.insertUser(User(2, "Bob"))

    val users = repo.getAllUsers()
    users.foreach(u => println(s"${u.id} -> ${u.name}"))
  }
}
