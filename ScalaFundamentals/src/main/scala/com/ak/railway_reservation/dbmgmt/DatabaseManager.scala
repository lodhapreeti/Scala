package com.ak.railway_reservation.dbmgmt

import com.ak.railway_reservation.MySQLConnection
import com.ak.railway_reservation.dbmgmt.DBOperation
import com.ak.railway_reservation.reservation.Reservation
import com.ak.railway_reservation.train.Train

import scala.practice.ErrorHandlingExamples.input
import scala.practice.TestTypeClass
import scala.util.{Try, Success, Failure}
import com.ak.railway_reservation.user.User

import java.sql.Connection


class DatabaseManager {
  def insertObject[A](a:A)(using s: DBOperation[A]): String  = {
    val returnVal : Try[Int] = s.insert(a)
    returnVal match {
      case Success(value) => "Operation completed successfully"
      case Failure(exception) => s"Exception occurred : ${exception.getMessage} "
    }

  }

  def initConnection(): Connection = {
    MySQLConnection.getConnection()
  }

}
trait DBOperation[A] {
  def insert(a:A) : Try[Int]
  //def getAll() : List[A]
}
object DBOperation {
  given DBOperation[User] with
    override def insert(user: User):  Try[Int] = Try{
      println(s"Inserting User ${user.id}")
      val conn = MySQLConnection.getConnection()
      val sql = "INSERT INTO users (id, name) VALUES (?, ?)"

      try {
        val stmt = conn.prepareStatement(sql)
        stmt.setInt(1, user.id)
        stmt.setString(2, user.name)
        stmt.executeUpdate()
      }
      /*catch {
        case  e :Exception =>
          println(s"Exception occured ${e.getMessage}")
          return -1
      }*/
      finally {
        conn.close()
      }
    }

  given DBOperation[Train] with
    override def insert(train: Train):  Try[Int]  =Try {
        println(s"Inserting User ${train.trainNumber}")
        val conn = MySQLConnection.getConnection()
        val sql = "INSERT INTO trains (id, name,source, destination) VALUES (?, ?,?,?)"

        try {
          val stmt = conn.prepareStatement(sql)
          stmt.setInt(1, train.trainNumber)
          stmt.setString(2, train.trainName)
          stmt.setString(3,train.source)
          stmt.setString(4,train.destination)
          stmt.executeUpdate()
        }
        /*catch {
          case e: Exception =>
            println(s"Exception occured ${e.getMessage}")
            return -1
        }*/
        finally {
          conn.close()
        }
      }
  given DBOperation[Reservation] with
    override def insert(reservation: Reservation):  Try[Int]  = Try{
      println(s"Inserting Reservation ${reservation.reservationId}")
      val conn = MySQLConnection.getConnection()
      val sql = "INSERT INTO reservation (user_id, train_id,id) VALUES (?, ?,?)"

      try {
        val stmt = conn.prepareStatement(sql)
        stmt.setInt(1, reservation.userId)
        stmt.setInt(2, reservation.trainId)
        stmt.setString(3, reservation.reservationId)
        stmt.executeUpdate()
      }
      /*catch {
        case e: Exception =>
          println(s"Exception occured ${e.getMessage}")
          return -1
      }*/
      finally {
        conn.close()
      }
    }
      /*extension [A](value: A)
      def insert(using s: DBOperation[A]): Int = s.insert(value)*/
}



