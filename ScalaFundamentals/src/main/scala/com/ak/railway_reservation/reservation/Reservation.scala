package com.ak.railway_reservation.reservation

import com.ak.railway_reservation.dbmgmt.DBObject
import com.ak.railway_reservation.train.Train

case class Reservation (userId:Int, trainId:Int, reservationId:String) extends  DBObject


