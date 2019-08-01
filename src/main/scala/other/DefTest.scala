package other

object DefTest {

  def sumInt(x: Int, y: Int): Int = {
    println("执行sumInt方法")
    x + y
  }

  def main(args: Array[String]): Unit = {
    //val 类型, val在声明时就会把右边表达式的结果计算并赋值给val变量
    // 一旦赋值, 右边的表达式就不在计算
    val v = sumInt(3, 5)
    println(s"打印val对象v: $v")
    println(s"第二次打印val对象v: $v")

    // def 类型的变量, 在声明赋值时, 右面的变化是不会马上计算结果的
    // 在def变量每次被调用的时候, 等号右边的表达式是都会被重新计算一次的
    def d = sumInt(3, 5)

    println(s"变量d已经被定义赋值过了: $d")
    println(s"第二次打印def: $d")

    // lazy 定义变量
    // lazy 变量, 在声明赋值时, 等号右边的表达式不会马上计算结果
    // lazy 在对象第一次调用的时候, 等号右边表达式会计算一次,并赋值给对象
    // 后续的对lazy对象的再次调用, 右边的表达式是将不会再被重新计算的
    lazy val l = sumInt(3, 5)
    println(s"lazy变量l已经被赋值过了: $l")
    println(s"变量l的值: $l")
    println(s"第二次打印lazy对象: $l")
  }
}
