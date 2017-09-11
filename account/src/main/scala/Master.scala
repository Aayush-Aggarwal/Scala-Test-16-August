package main.scala

import scala.collection.mutable

/**
  * Created by knoldus on 8/16/17.
  */
trait MasterData {

  val listOfUser: mutable.Map[Long, User] = mutable.Map[Long, User]()
}

case class User(name: String, emailId: String, phoneNumber: Long, password: String)
