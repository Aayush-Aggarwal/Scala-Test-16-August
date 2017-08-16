import main.scala.{AccountService, User}


class AccountServiceTest extends org.scalatest.FunSuite {

  val user = User("ayush", "ayush@knoldus.in", 7838467221L, "ayushaggarwal")

  val accService = new AccountService()

  import accService._

  test("It should be able to add new user") {
    assert(accService.addUser(user))
  }

  test("It should not add dublicate user") {
    assert(!accService.addUser(user))
  }

  test("Authenticating a user with a token with success") {
    assert(!accService.authenticatedUser("ayush", "ayushaggarwal").equals("fail"))
  }

  test("Fail to Authenticate a user with a token") {
    assert(!accService.authenticatedUser("ayush", "ayushaggarwal").equals("fail"))
  }

}
