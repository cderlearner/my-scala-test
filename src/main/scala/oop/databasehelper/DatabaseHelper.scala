package oop.databasehelper

trait DatabaseHelpers {

  def writeable[T](f: => T) = {
    val key = LocalProperties.ReadOnly
    val oldValue = LocalProperties.get(key)
    LocalProperties.set(key, false)
    println("hello")
    try {
      f
    } finally {
      oldValue match {
        case Some(value) => LocalProperties.set(key, value)
        case None => LocalProperties.remove(key)
      }
      println("world!")
    }
  }
}


object DatabaseHelper extends DatabaseHelpers {

  def tt() = writeable {
    println("猪猪！")
  }

  def main(args: Array[String]): Unit = {
    tt()
  }
}