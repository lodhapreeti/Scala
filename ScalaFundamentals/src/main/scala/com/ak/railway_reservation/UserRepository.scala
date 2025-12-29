package com.ak.railway_reservation

import java.sql.Connection

class UserRepository {

  def insertUser(user: User): Unit = {
    val conn = MySQLConnection.getConnection()
    val sql = "INSERT INTO users (id, name) VALUES (?, ?)"

    try {
      val stmt = conn.prepareStatement(sql)
      stmt.setInt(1, user.id)
      stmt.setString(2, user.name)
      stmt.executeUpdate()
    } finally {
      conn.close()
    }
  }

  def getAllUsers(): List[User] = {
    val conn = MySQLConnection.getConnection()
    val sql = "SELECT id, name FROM users"

    try {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery(sql)

      val buffer = scala.collection.mutable.ListBuffer[User]()
      while (rs.next()) {
        buffer += User(rs.getInt("id"), rs.getString("name"))
      }
      buffer.toList
    } finally {
      conn.close()
    }
  }
}