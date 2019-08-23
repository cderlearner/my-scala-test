package com.example.myscalatest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

object ScalaApp {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ScalaApp], args: _*)
  }
}

@SpringBootApplication
class ScalaApp {

//  val minimalFields = Seq("id")
//  val accountFields = Seq("email", "encrypted_telephone", "areacode", "screen_name", "created_at", "client", "created_ip", "step", "status", "password", "snow", "type", "tel_bind_at")
//  val profileFields = Seq("profile_image_url", "description", "gender", "province", "city", "domain", "location", "url", "blog_description", "verified", "verified_type", "verified_description", "verified_source", "ability", "last_status_id", "last_comment_id", "flags","privacy_agreement")
//  val fields = Seq(minimalFields, accountFields, profileFields).flatten
//  val stmt = fields.mkString("select ", ",", " from User where id > ? limit ?")
//
//  println(fields)
//  println(stmt)

//  var serviceMap = {
//    Map(
//      "account" -> "4",
//      "accountBinding" -> "3",
//      "accountSettings" -> "2")
//  }
//
//  serviceMap += ("account" -> "6")
//
//  println(serviceMap)

  var ip = "11"
  var port = "7950"
  println(s"$ip:" + port)
}
