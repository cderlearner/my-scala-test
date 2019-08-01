package other

import scala.collection.mutable.ArrayBuffer

object ArrayBufferTest {

  def main(args: Array[String]): Unit = {

    //ArrayBuffer声明
    val ab1 = ArrayBuffer(1, 2, 3, 4)
    val ab2 = new ArrayBuffer[String](2)
    val ab3 = new ArrayBuffer[Int]()
    println(ab1)
    println(ab2)
    println(ab3)

    //获取和修改内容
    println(ab1(3))
    ab1(0) = 100
    println(ab1)

    println(ab2.length)

    //新增数据到arrayBuffer中
    ab2 += "abc"
    ab2 += "def"
    println(ab2)

    // +号等不带=符号的操作 会返回一个新的arrayBuffer,
    // 而原来的arrayBuffer对象不发生变化
    ab2 + "ccc"
    println(ab2)

    println("ccc" +: ab2)
    println(ab2)

    ab2 -= "abc"
    println(ab2)
    ab2 -= "aaa"
    println(ab2)

    //插入数据到指定位置
    // 如果写入的起始位置超出了arraybuffer中的
    // 现有的index值的化将会报错
    ab2.insert(0, "abc", "eee")
    ab2.insert(2, "fff", "ggg")
    println(ab2)

    ab2.remove(2, 2)
    println(ab2)


    //drop方法也是删除arrayBuffer中的数据,
    // 但是它返回一个新arrayBuffer而不会修改原来的arrayBuffer的数据
    println(ab2.drop(1))
    println(ab2.dropRight(1))
    println(ab2)

    //更新某位置处的数据
    ab2.update(1, "更新内容")
    println(ab2)

    val ab4 = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // 返回一个新的arrayBuffer, 在新的arrayBuffer只有偶数
    // drop只会删除第一个符合条件的数, 并返回一个新的数组
    val result = ab4.dropWhile(x => x % 2 != 0)
    println(result)

    val result1 = ab4.filter(x => x % 2 == 0)
    println(result1)

    //定义一个函数, 接受一个arrayBuffer, 和一个函数
    // 函数对每一个arrayBuffer中的值进行计算,
    // 返回true则在该arrayBuffer中删除该元素,
    // 返回false的话则从改arrayBuffer中留下该元素
    removerBy(ab4, x => x % 2 == 0)
    println(ab4)


    val list6 = List(1, 2, 3, 4, 5, 6)

    val reduceResult = list6.reduce((x1, x2) => x1 + x2)
    println(s"list6的元素总和是: ${reduceResult}")


  }

  def removerBy(ab: ArrayBuffer[Int], f: Int => Boolean): Unit = {
    //对数组进行遍历
    for (item <- ab) {
      if (!f(item)) ab -= item
    }
  }


}
