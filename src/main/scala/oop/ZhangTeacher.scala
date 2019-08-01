package oop

trait Dance {
  def Balei()

  def floor()

  //trait类似于java的接口，但可以做具体方法的实现
  def eat() {}
}

trait Driver {
  def shache(): String

  def piaoyi()
}

//scala中，只能继承一个父类，但是可以混入多个特质（trait)
//需要实现特质中未实现的方法
//此外，需要注意的是，如果未继承任何类或抽象类，在混入特质时，
//比如有且仅有一个特质需要用extends来混入，而其他特质用with混入
class ZhangTeacher extends Dance with Driver {
  def Balei(): Unit = {
    println("balei")
  }

  def floor(): Unit = {
    ???
  }

  def piaoyi(): Unit = {
    ???
  }

  def shache(): String = {
    ???
  }
}

object ZhangTeacher {
  def main(args: Array[String]): Unit = {
    val teacher = new ZhangTeacher
    teacher.Balei()
  }
}