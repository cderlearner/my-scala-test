package other

object HelloWorld {
  def main(args: Array[String]): Unit = {
    System.out.println("Hello World!")

    // 函数式
    val arr = Array("hello", "yinzhengjie", "hello", "world", "yinzhengjie", "big", "data") //声明一个数组
    arr.map((_, 1))
      .groupBy(_._1)
      .mapValues(_.length)
      .toList
      .sortBy(-_._2)
      .foreach(System.out.println);

    //基础
    /**
      * 变量的定义可以用关键字var和val修饰
      * var修饰的变量值可以更改
      * val修饰的变量值不可用改变，相当于Java中final修饰的变量
      * 定义变量格式如下 :
      * 方式一 : var | val 变量名称 : 类型 = 值
      * 方式二 : var | val 变量名称 = 值
      *
      */
    val name: String = "尹正杰"
    val age: Int = 26
    val blog = "http://www.cnblogs.com/yinzhengjie/tag/Scala%E8%BF%9B%E9%98%B6%E4%B9%8B%E8%B7%AF/"
    println("姓名 :" + name, "年龄 :" + age, "博客地址 :" + blog)

    /**
      * Unit数据类型相当于Java中void关键字，但是在scala它的表示形式是一对括号，即"()"。
      * 由于我println返回值为空，因此我定义了一个变量res它拿到的返回值必然为空。
      */
    val res: Unit = println("yinzhengjie") // 类似java中的function
    println(res)
  }
}
