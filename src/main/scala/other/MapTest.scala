package other

object MapTest {

  def main(args: Array[String]): Unit = {

    //map的声明, 自变量, 取值
    val map1 = Map(1 -> "a", 2 -> "b", 3 -> "c")
    println(map1)

    val map2 = Map((1, "a"), (2, "b"), (3, "c"))
    println(map2)

    //map的取值
    println(map1(1))
    println(map2(1))

    val map3 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(map3("a"))


    //遍历
    map3.foreach(
      (k) => println(s"key: $k")
    )
    map3.foreach(
      x => println(s"key:${x._1}, value:${x._2}")
    )

    println("-----------------------------------------")
    for (x <- map3) {
      println(s"key:${x._1}, value:${x._2}")
    }

    for ((k, v) <- map3) {
      println(s"key:$k, value:$v")
    }

    for (ks <- map3.keySet) {
      println(s"key:$ks, value:${map3(ks)}")
    }


    //不可变map无法重新赋值
    //map3("a") = 100

    //get方法获取指定key的value值
    val map4 = Map("zhang" -> 80, "li" -> 85, "liu" -> 90)
    println(map4("zhang"))
    println(map4.get("zhang"))

    //小括号方法获取key的value值时,如过key不存在, 程序会抛异常
    //    println(map4("wang"))
    println(map4.get("wang"))

    //map ++
    println(map3 ++ map4)
    //会覆盖
    println(map3 ++ Map("c" -> 100))

    //判断map4中是否包含key :"zhang"
    println(map4.contains("zhang"))

    //CopyToArray

    val map5 = Map("apple" -> 5, "pear" -> 4, "peach" -> 5, "tomato" -> 6, "banana" -> 7)
    //计算出value 代表key长度的kv对数量
    val count = map5.count(
      x => x._1.length == x._2
    )
    println(count)
    //计算出key长度是5的数量
    val count1 = map5.count(
      x => x._1.length == 5
    )
    println(count1)

    //drop, 从前往后删除, 写入后的自动排序
    println(map5)
    println(map5.drop(2))
    println(map5.dropRight(2))

    //过滤掉key长度等于5的kv对
    val filter1 = map5.filterKeys(x => x.length != 5)
    println("过滤掉key长度为5 的key, 结果为: " + filter1)

    val filter2 = map5.filter(x => x._1.length != 5)
    println("过滤掉key长度为5 的key, 结果为: " + filter2)

    // flatMap, 展平成 List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val map6 = Map("a" -> List(1, 2, 3), "b" -> List(4, 5, 6), "c" -> List(7, 8, 9))
    println(map6)
    val flatMap = map6.flatMap(x => x._2)
    println(flatMap)

    val map7 = Map(
      "zhang" -> List("zhangfei" -> "shu", "zhangliao" -> "wei")
      , "liu" -> List("liubei" -> "shu", "liuzhang" -> "zhong")
    )
    val flatMap1 = map7.flatMap(x => x._2)
    println(flatMap1)

    //
    val map8 = Map(
      "zhang fei" -> "shu"
      , "zhang liao" -> "wei"
      , "liu bei" -> "shu"
      , "liu zhang" -> "zhong"
    )
    //按照国家分成N组
    val result = map8.groupBy(x => x._2)
    println(result)

    //按照姓氏来分组
    val resultGroupByFirstName = map8.groupBy(
      x => x._1.split("\\s")(0)
    )
    println(resultGroupByFirstName)

    //head tail init last
    println(map8.head)
    println(map8.tail)
    println(map8.init)
    println(map8.last)

    //map方法, 对keyvalue对进行映射转换
    val map9 = Map("小张" -> 3000, "小李" -> 4500, "小王" -> 5000, "小刘" -> 4000)
    //每个人加500
    val upSalary = map9.map(x => (x._1, x._2 + 500))
    println(upSalary)
    val upSalary1 = map9.mapValues(x => x + 500)
    println(upSalary1)

    //工资大于4000的为高收入, 否则是低收入, 在姓名前打上高收入或低收入的标签
    // 如 [低收入] 小张
    val upSalary2 = map9.map(
      x => (
        if (x._2 > 4000) "[高收入]" + x._1 else "[低收入]" + x._1,
        x._2
      )
    )
    println(upSalary2)

    val tagResult = map9.map(
      x => (
        s"${if (x._2 > 4000) "[高收入]" else "[低收入]"} ${x._1}"
        , x._2
      )
    )
    println(tagResult)

    //key 最大最小值
    println(s"map1最大值: ${map1.max}")
    println(s"map1最大值: ${map1.min}")

    //maxBy map9根据工资来返回最大值
    val maxSalary1 = map9.maxBy(x => x._2)
    println(s"最高工资: ${maxSalary1}")

    val maxSalary2 = map9.map(x => (x._2, x._1)).max
    println(s"最高工资: ${maxSalary2}")

    //reduce, 计算月支出map9, 将map9中的所有value加起来
    val salaryMonthly = map9.reduce(
      (x1, x2) => {
        ("月支出", x1._2 + x2._2)
      }
    )
    println(salaryMonthly)

    val salaryMonthlyFold = map9.fold(("月支出", 0))((c, x) => (c._1, c._2 + x._2))
    println(salaryMonthlyFold)

    //reduce 和fold的不同是fold需要一个初值, 他们的不足是都会受输入的类型限制,
    // 迭代函数的输入类型要和输入类型输出一致
    // foldLeft, foldRight, aggragate没有这个限制
    val salaryMonthlyFoldLeft = map9.foldLeft(0)((c, x) => c + x._2)
    println(s"月支出: $salaryMonthlyFoldLeft")


    val salaryMonthlyAggregate = map9.aggregate(0)(
      (c, x) => c + x._2
      , (c1, c2) => c1 + c2
    )
    println(s"月支出: ${salaryMonthlyAggregate}")

    //可变的map
    val mmap1 = scala.collection.mutable.Map(1 -> "a", 2 -> "b", 3 -> "c")
    println(mmap1)
    println(mmap1(1))
    println(mmap1.get(1))
    mmap1.put(4, "d")
    mmap1.remove(3)
    println(mmap1)
    mmap1 += (5 -> "e")
    println(mmap1)

    mmap1.update(1, "修改后的结果")
    println(mmap1)


    //元组数据类型, 非常重要的数据类型


  }

}
