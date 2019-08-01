package other

object TupleTest {

  def main(args: Array[String]): Unit = {
    //元组的声明, 字面量, 取值
    val tuple = (1, 2, "a", 3.0, 1231, true)
    println(tuple)
    val person = (1, "小张", 23, "12345567", "是发达")
    val pairTuple = ("a", 1) //等同于("a"->1)

    println(person)
    println(pairTuple)

    // 根据位置进行取值的,
    println(person._2)
    // 元组也是不可变的, 定义之后不能改变
    //    person._2 = "小明"

    //元组可以进行多个变量定义和赋值
    val list = List(1, 2, 3)
    val (one, two, three) = (list(0), list(1), list(2))
    println(one)
    println(two)
    println(three)

    //    for(x <- tuple){
    //      println(x)
    //    }

    //声明时, 元组的数据数量和类型都已经确定了, 不可更变, 是不可变的
    //没有循环变量的方法

    //

    val tupleResult = tupleTest("call1")
    println(tupleResult)


    //queue, Stack 自己看一下代码

    //Optio类一般是用来封装替他类型的对象
    //一般一个用在方法的返回值上, 以避免方法返回空值带来替他的问题


  }

  def tupleTest(a: String) = {

    val value1 = s"return value1$a"
    val value2 = s"return value2$a"
    val value3 = s"return value3$a"

    (value1, value2, value3)
  }

}
