package oop.databasehelper

/**
  * 从上面的描述我们可以知道，sealed 关键字主要有2个作用：
  *
  * 其修饰的trait，class只能在当前文件里面被继承
  * 用sealed修饰这样做的目的是告诉scala编译器在检查模式匹配的时候，让scala知道这些case的所有情况，scala就能够在编译的时候进行检查，看你写的代码是否有没有漏掉什么没case到，减少编程的错误。
  */
object LocalProperties {

  sealed abstract class Name[T]

  object ReadOnly extends Name[Boolean]

  private val properties = new ThreadLocal[collection.mutable.Map[Name[_], Any]] {
    override def initialValue() = {
      collection.mutable.Map[Name[_], Any]()
    }
  }

  def get[T](name: Name[T]) = {
    properties.get.get(name).asInstanceOf[Option[T]]
  }

  def set[T](name: Name[T], value: T) = {
    properties.get.put(name, value)
  }

  def remove[T](name: Name[T]) = {
    properties.get.remove(name)
  }

  def clear = {
    properties.remove
  }
}
