package main.scala

import org.mindrot.jbcrypt.BCrypt

import scala.collection.mutable

/**
  * Created by knoldus on 8/16/17.
  */
class AccountService extends MasterData {

  def addUser(user: User): Boolean = {

    val users = listOfUser.map(users => users._1 == user.phoneNumber)
    if (users.isEmpty || listOfUser.isEmpty) {
      listOfUser += (user.phoneNumber -> user)
      true
    }
    else
      false
  }

  def authenticatedUser(name: String, password: String): String = {
    val users = listOfUser.filter(usr => usr._2.name == name && usr._2.password == password)
    if (users.isEmpty)
      "Failed"
    else {
      val token = BCrypt.hashpw(password, BCrypt.gensalt())
      token
    }
  }
}
