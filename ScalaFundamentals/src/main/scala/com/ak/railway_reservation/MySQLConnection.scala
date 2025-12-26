package com.ak.railway_reservation

import java.sql.{Connection, DriverManager}

object MySQLConnection {

  private def env(name: String): String =
    sys.env.getOrElse(name, throw new RuntimeException(s"Environment variable '$name' is not set"))

  // Read from environment variables
  private val host     = env("DB_HOST")        // e.g. "mydb.example.com"
  private val port     = env("DB_PORT")        // e.g. "3306"
  private val database = env("DB_NAME")        // e.g. "mydb"
  private val username = env("DB_USER")
  private val password = env("DB_PASSWORD")

  private val url = s"jdbc:mysql://$host:$port/$database?useSSL=false"

  // Load driver once
  Class.forName("com.mysql.cj.jdbc.Driver")

  def getConnection(): Connection = {
    DriverManager.getConnection(url, username, password)
  }
}