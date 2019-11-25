package com.example.myscalatest

object USTest {

  case class tt(name: String)

  def getTT(): AnyRef = None


  def main(args: Array[String]): Unit = {
//    val profile = getTT()
//    val verifiedType = profile match {
//      case None => 1
//      case Some(p) =>
//        0
//    }
//
//    println(verifiedType)


    case class t2(h: String)

    val testOp = Some(t2("hello world"))

    testOp.filter(!_.equals("hello world")) match {
      case Some(token)  =>
        println(token+"____")
      case _ =>
        println("hhhhhhhhhhh")
    }
  }
}
