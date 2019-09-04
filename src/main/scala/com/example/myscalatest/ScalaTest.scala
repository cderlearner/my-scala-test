package com.example.myscalatest

class ScalaTest {
  println("hello world")

}

class A{
  def fun1(a:String) = println(a)
  def fun2() = println("fun2")
  private[this] var t = 1
  def pt(): Unit = println(t)
}


object ScalaTest {
  def main(args: Array[String]): Unit = {
    val classA = Class.forName("com.example.myscalatest.A")
    val method = classA.getDeclaredMethod("fun1", classOf[String])
    val obj = classA.newInstance()
    method.invoke(obj, "5")// 如果是Int的话,要用new Integer(5)

    val field = classA.getDeclaredField("t")
    field.setAccessible(true)
    field.setInt(obj, 4)
    classA.getDeclaredMethod("pt").invoke(obj)

  }
}