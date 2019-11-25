package com.example.myscalatest

object ScalaFunctionTest {

  def main(args: Array[String]): Unit = {
//    val xs = Iterator
//      .from(1)
//      .dropWhile(_ % 2 != 0)
//      .takeWhile(_ < 10)
//      .toList
//    println(xs)


    Stream.from(0, 10).dropWhile { start =>
      println(start)
      start == 9
    }
  }
}
