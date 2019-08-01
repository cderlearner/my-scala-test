package other

import scala.collection.mutable.ListBuffer

object ListTest {

  def main(args: Array[String]): Unit = {
    //List的声明和字面量
    val list = List(1, 2, 3, 4, 5)
    val list1 = List()
    println(list)
    println(list1)
    println(list(1))

    // list元素对象,不能更改
    // List(0) = 100

    // 元素的添加,
    println(list.::(23))
    println(23 :: list)
    println(33 :: 43 :: list)

    println(list.:+(22))
    println(list :+ 22)

    //两个List合并
    val list2 = List(1, 2, 3)
    val list3 = List(1, 2, 3)
    println(list2 ++ list3 ++ list)


    //list4有多少个数是大于5的
    val list4 = List(1, 2, 3, 4, 5, 6, 7)
    val bt5Count = list4.count(x => x > 5)
    println(s"list4中大于5的数共有${bt5Count}个")


    //判断list4 是否以6,7作为最后两个元素结尾的
    val isEndWith67 = list4.endsWith(List(6, 7))
    println(s"List4${if (isEndWith67) "是" else "不是"} 以6,7结尾的")


    //find: 返回list中第一个满足查询条件的元素, 并用Option封装
    //找出list4中第一个大于4 并且是偶数的元素
    val valBt4 = list4.find(x => x > 4 && x % 2 == 0)
    println(s"第一个大于4并且是偶数的元素为: $valBt4")

    val list5 = List("hadoop is good", "spark is better", "sql is best")
    //把list5中的每个元素各自拆分成一个单词一个元素的list
    // flatMap, 是一个展平操作, 类似hive中的explore, 它接收一个函数, 函数的输入
    // 是一个元素, 函数的输出是一个集合
    // 集合中的每一个元素品在一起形成一个新的list
    val flatedList = list5.flatMap(x => x.split("\\s"))
    println(flatedList)

    // 对List中所有元素进行迭代计算的函数
    // reduce就相当于把集合中的没个元素按照迭代函数迭代计算
    val list6 = List(33, 55, 22, 78, 12, 43)
    val reduceResult = list6.reduce((x1, x2) => x1 + x2)
    println(s"list6的元素总和: $reduceResult")
    val maxResult = list6.reduce((x1, x2) => if (x1 > x2) x1 else x2)
    println(s"list6中最大的值是: $maxResult")


    // foldLeft, foldRight
    // 多了一个初始值
    // 对list6 进行计算
    val foldResult = list6.fold(0)((x1, x2) => x1 + x2)
    val foldResult1 = list6.fold(1)((x1, x2) => x1 + x2)
    println(s"foldResult计算的元素总和是: $foldResult")
    println(s"foldResult计算的元素总和是: $foldResult1")

    //把list6中的元素聚合成一个字符场, 字符串中包含每个元素
    val strFoldResult = list6.foldLeft("")((c, x) => s"$c${if (c == "") "" else ","}$x")
    println(s"$strFoldResult")

    val strFoldRightResult = list6.foldRight("")((c, x) => s"$c${if (c == "") "" else ","}$x")
    println(s"$strFoldRightResult")

    val strAggrateResult = list6.aggregate("")(
      (c, x) => s"$c${if (c == "") "" else ","}$x" //迭代计算每个分区的元素
      , (c1, c2) => s"$c1,$c2" //迭代计算每个分区的结果值
      //(每个分区的计算结果参与迭代运算)
    )
    println(s"AggrateResult的计算结果是: $strAggrateResult")


    //用aggrate计算list的累加值
    val sumAggragateResult = list6.aggregate(0)(
      (c, x) => c + x
      , (c1, c2) => c1 + c2
    )
    println(s"$sumAggragateResult")


    //List具有递归结构, 和其他类型集合一样具有协变性
    //比方说Student 是Person的子类
    // List<String> 一个Person<String> 的子类
    // <? extends Person>
    //采用: 及Nil进行列表构建
    // 值为null的list就是Nil

    //把a, b, c, d 构建一个list
    val list7 = "a" :: "b" :: "c" :: "d" :: Nil
    println(s"list7: " + list7)

    //获取list的第一个元素
    println(list7.head)

    //获取list的出第一个之外其他的元素
    println(list7.tail)

    //获取list的最后一个元素
    println(list7.last)

    //获取list的出最后一个元素之外的其他元素
    println(list7.init)

    //把list按照奇数偶数进行分组
    val groups = list6.groupBy(x => if (x % 2 == 0) "偶数" else "奇数")
    println(groups)

    //拉链操作, 当元素个数不一致时, 匹配不上位置的元素会在结果中直接被丢弃
    val list8 = List(1, 2, 3, 4, 5)
    val list9 = List("a", "b", "c", "d")
    println(list8 zip list9)

    //map, 把list6中的每一个元素转换成字符串返回一个新的list, 其每一个元素都是String类型
    val list10 = list6.map(x => x.toString)
    println(list10)


    //定义一个java的list对象
    val list11 = new java.util.ArrayList[String]()
    list11.add("123")
    list11.add("456")
    println(list11.get(0))
    println(list11.get(1))


    //ListBuffer声明, 字面量, 取值, 改值
    val mList = ListBuffer(1, 2, 3, 4)
    println(mList(1))
    println(mList(2))
    mList(0) = 100
    println(mList)
    mList.insert(2, 8, 8, 8)
    println(mList)
    mList.update(0, 125)
    println(mList)
    mList.remove(2)
    println(mList)


  }


}
