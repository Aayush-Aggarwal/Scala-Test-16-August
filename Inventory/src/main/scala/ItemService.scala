package main.scala

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by knoldus on 8/16/17.
  */
class ItemService {
  val PHOTO_SIZE = 20.30
  val RATING = 4
  val PRICE = 50.0
  val items = Map("cloths" ->
    List(Item("cloths", "Cloths", Photo("PhotoName", PHOTO_SIZE), "vendor1", PRICE, "ItemName", RATING))
  )

  def searchForItem(category: String, name: String): Future[Option[Item]] = {
    Future {
      val itemForCategory: Option[List[Item]] = items.get(category)
      itemForCategory.flatMap(listOfItem => listOfItem.find(_.itemName == name))
    }
  }

  def sortItem(filter: String): Future[List[Item]] = {
    Future {
      filter match {
        case "price:low to high" => items.values.toList.flatten.sortBy(item => item.itemPrice)
        case "price:high to low" => items.values.toList.flatten.sortBy(item => item.itemPrice).reverse
        case "rating:low to high" => items.values.toList.flatten.sortBy(item => item.rating)
        case "rating:high to low" => items.values.toList.flatten.sortBy(item => item.rating).reverse
        case _ => List()

      }
    }
  }

}
