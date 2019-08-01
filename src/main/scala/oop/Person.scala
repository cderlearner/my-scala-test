package oop

class Person(v1: String, v2: Int) {
  private var name = v1
  private var age = v2
  println("…………")
  println("***")

  def this(v1: String) = {
    this(v1, 0)
  }

  def this(v2: Int) {
    this("", v2)
  }

  def this() {
    this("", 0)
  }

  def getName() = {
    this.name
  }

  def setName(name: String) = {
    this.name = name
  }

  def getAge() = {
    this.age
  }

  def setAge(age: Int) = {
    this.age = age
  }

  def say() {
    println("say word")
  }

}