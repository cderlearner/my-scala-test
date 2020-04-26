package com.example.myscalatest

object OtherTest {

  def main(args: Array[String]): Unit = {
    if (Constant.p.getKey) {
      println(Constant.p.getValue)
    } else {
      println("---")
    }

    println(test1())
  }

  def test1(): Int = {
    if (Constant.p.getKey) {
      Constant.p.getValue
    }
    0
  }
}
