package other

object OptionTest {
  def main(args: Array[String]): Unit = {

    val value1 = getValue(4)
    val value2 = getValue(-1)
    println(value1)
    println(value2)
    println(value1.get)

    val value3 = getValue(-1)
    println(value3.getOrElse(0))

    //match case
    //Some Option 可以封装任意的类型, 一般用于函数返回值上
    //如 map 的 get 方法
    val some1 = Some("abc")
    val some2 = Some(true)
    println(x = some1.getClass.getSuperclass)
    println(some1)
    println(some2.get)
  }


  def getValue(x: Int): Option[Int] = {
    if (x > 0) {
      Some(x)
    } else {
      None
    }
  }


}
