package com.example.myscalatest

import java.util

import scala.collection.JavaConverters

object ScalaFunctionTest {

  def main(args: Array[String]): Unit = {
//    val xs = Iterator
//      .from(1)
//      .dropWhile(_ % 2 != 0)
//      .takeWhile(_ < 10)
//      .toList
//    println(xs)


/*
    Stream.from(0, 100).dropWhile { start =>
      println(start)
     start <=300
    }

    var numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val list = numbers.dropWhile(_ % 2 != 0)
    println(list)

*/


    val seql = JavaConverters.asScalaIteratorConverter(util.Arrays.asList(1L, 2L).iterator()).asScala.map(long2Long).toList

    println(seql)
  }
}
