package oop

object PersonObject {
  def main(args: Array[String]): Unit = {
    val person = new Person("你好", 1)
    person.say()
  }
}
