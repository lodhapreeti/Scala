package com.ak.railway_reservation.train

import com.ak.railway_reservation.dbmgmt.DBObject

case class Train(trainNumber:Int, trainName:String, source:String, destination:String) extends DBObject
