package com.example.myscalatest

trait PrivacyDao {

  def select(userId: Long): Option[String]

  def insertOrUpdate(privacy: String)

  def updateLetterAndComment(userId: Long, letter: String, comment: String)

  def updateStockPreferences(userId: Long, stock: String, color: String)
}

class SpringJdbcPrivacyDao extends PrivacyDao {

  def select(userId: Long): Option[String] = {
    Some("111")
  }

  def insertOrUpdate(privacy: String) = {

  }

  def updateLetterAndComment(userId: Long, letter: String, comment: String) = {

  }

  def updateStockPreferences(userId: Long, stock: String, color: String) = {

  }

  private def fields = List(
    "uid", "comment", "letter", "stock", "st_color",
    "comment_alert", "email_weekly", "email_daily", "email_announce", "email_activity",
    "follower", "mention", "notice", "calendar", "paid_mention"
  )

}

trait CachedPrivacyDao extends PrivacyDao {

  val privacyRedis: String

  abstract override def select(userId: Long): Option[String] = {
    println(Some("222"))
    super.select(userId)
  }

  abstract override def insertOrUpdate(privacy: String) {

  }

  abstract override def updateLetterAndComment(userId: Long, letter: String, comment: String) = {

  }

  abstract override def updateStockPreferences(userId: Long, stock: String, color: String) = {

  }

}

object Privacy {
  def main(args: Array[String]): Unit = {
    val privacyDao = new SpringJdbcPrivacyDao with CachedPrivacyDao {
      val privacyRedis = "你好"
    }
    println("1111:" + privacyDao.select(1))
  }
}
