package com.ak.railway_reservation

import com.ak.railway_reservation.dbmgmt.{DBObject, DatabaseManager}
import com.ak.railway_reservation.reservation.*
import com.ak.railway_reservation.train.Train
import com.ak.railway_reservation.user.{User, UserRepository}

import scala.io.StdIn
import scala.practice.ErrorHandlingExamples.input
import scala.util.{Failure, Random, Success, Try}

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
  val dbManager = DatabaseManager()
  @main
  def mainfn(): Unit = {
    //setupUserData()
    //setTrainInfo()
    println("Select from below options : \n 1:Make Reservation 2:List Reservation 3:Cancel reservation")
    val input = StdIn.readInt()
    if(input!=1) println("Option not currently supported")
    if(input==1) {
      println("Enter UserID for which reservation is to be made")
      val userId = StdIn.readInt()
      println("Enter TrainID for which reservation is to be made")
      val trainId = StdIn.readInt()
      insertDatabaseObjects(List(Reservation(userId, trainId, generateUniqueReservationId())))
    }
  }

  def generateUniqueReservationId () : String = {
    Random.alphanumeric.take(5).mkString
  }
  def setTrainInfo(): Unit = {
    val trainList = List(Train(1,"Rajdhani Express","Pune", "Delhi"),Train(2, "Duronto", "Mumbai", "Delhi"))
    insertDatabaseObjects(trainList)
  }

  def setupUserData() :Unit = {
    val userList = List(User(1,"Maria"), User(2,"Anthony"))
    insertDatabaseObjects(userList)
  }
  def insertDatabaseObjects(lst : List[DBObject]) :Unit = {
    for (objectInList <- lst) {
      val result = objectInList match {
        case x: User =>  dbManager.insertObject(x)
        case y: Train => dbManager.insertObject(y)
        case z: Reservation => dbManager.insertObject(z)
      }
      println(s"Received result while inserting $objectInList :  $result" )
      //val result = dbManager.insertObject(objectInList)
      /*result match {
        case 1 => println(s"Insert Successful ${objectInList.toString}")
        case 0 => println("Something went wrong")
        case -1 => println("Error occured while creating reservation")
      }*/
    }
  }
}
