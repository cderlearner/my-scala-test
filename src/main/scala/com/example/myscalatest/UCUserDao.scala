package com.example.myscalatest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

trait UserDao {

  def select(userIds: Iterable[Long], tryDB: Boolean = true): Map[Long, String]

  def selectFrom(userId: Long, limit: Int): Seq[Int]

  def selectIdAndStockColorFrom(userId: Long, limit: Int): Seq[(Long, Option[String])]

  def selectIdAndNicknameFrom(userId: Long, limit: Int): Seq[(Long, Option[String])]

  def userDeleteAccount(userId: Long): Option[String]
}

@Repository
class SpringJdbcUserDao extends UserDao {

  println("Hello SpringJdbcUserDao")

  def select(userIds: Iterable[Long], tryDB: Boolean = true) = {
    Map(1l -> "1")
  }

  def selectFrom(userId: Long, limit: Int) = {
    Seq(1)
  }

  def selectIdAndStockColorFrom(userId: Long, limit: Int) = {
    Seq((1l, Some("1")))
  }

  def selectIdAndNicknameFrom(userId: Long, limit: Int): Seq[(Long, Option[String])] = {
    Seq((2l, Some("2")))
  }

  def userDeleteAccount(userId: Long) = {
    Some("1")
  }

  val minimalFields = Seq("id")
  val accountFields = Seq("email", "encrypted_telephone", "areacode", "screen_name", "created_at", "client", "created_ip", "step", "status", "password", "snow", "type", "tel_bind_at")
  val accountFieldsForUserDel = Seq("email", "encrypted_telephone", "areacode", "screen_name", "created_at", "client", "created_ip", "step", "status", "password", "snow", "type")
  val profileFields = Seq("profile_image_url", "description", "gender", "province", "city", "domain", "location", "url", "blog_description", "verified", "verified_type", "verified_description", "verified_source", "ability", "last_status_id", "last_comment_id", "flags", "privacy_agreement")
}

@Repository
class CachedUserDao @Autowired()(private val userDao: SpringJdbcUserDao) extends UserDao {

  println("Hello CachedUserDao")

  def select(userIds: Iterable[Long], tryDB: Boolean = true) = {
    userDao.select(userIds, tryDB)
  }

  def selectFrom(userId: Long, limit: Int): Seq[Int] = {
    userDao.selectFrom(userId, limit)
  }

  def selectIdAndStockColorFrom(userId: Long, limit: Int): Seq[(Long, Option[String])] = {
    userDao.selectIdAndStockColorFrom(userId, limit)
  }

  def selectIdAndNicknameFrom(userId: Long, limit: Int): Seq[(Long, Option[String])] = {
    userDao.selectIdAndNicknameFrom(userId, limit)
  }

  def userDeleteAccount(userId: Long) = {
    userDao.userDeleteAccount(userId)
  }
}

