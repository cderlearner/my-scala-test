package other

import java.util.Random

object ArrayTest {

  def main(args: Array[String]): Unit = {

    val array = Array(1, 2, 3, 4, 5)

    println(array(0))

    //数组的元素是可变的
    array(0) = 100
    println(array.mkString(","))

    //数组的遍历
    println("数组遍历")
    for (i <- 0 until array.length) {
      println(array(i))
    }

    for (i <- array) {
      println(i)
    }

    println("foreach()")
    array.foreach(x => {
      println(x)
    })

    //数组的非字面量声明
    println("非字面量声明")
    val array1 = new Array[String](10)
    array1(0) = "a"
    array1(1) = "b"
    println(array1.mkString(","))

    //产生随机数组
    println("产生随机数组")
    getRandomArrayN(3)
    val randomArray = generateRandomArray(3)
    println(randomArray.mkString(","))


    //定义一个函数, 接受一个数组, 函数把这个数组的两两相邻的元素
    //调换位置
    println("调换位置")
    val arrayForRevert = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    pairRevertArray(arrayForRevert)
    println(arrayForRevert.mkString(","))


    //定义冒泡排序算法
    // 2,1,4,3,6,5,8,7,9
    // 01 12 23 34
    // 01 12 23
    // 01 12
    // 01
    println("定义冒泡排序算法")
    val arrayForBubbleSort = Array(2, 1, 4, 3, 6, 5, 8, 7, 9)
    bubbleSort(arrayForBubbleSort)
    println(arrayForBubbleSort.mkString(","))


    //定义选择排序算法
    // 0 1 2 3 4
    // 01 02 03 04
    //    12 13 14
    //       23 24
    //          34
    println("选择排序")
    val arrayForSelectSort = Array(2, 1, 4, 3, 6, 5, 8, 7, 9)
    chooseSort(arrayForSelectSort)
    println(arrayForSelectSort.mkString(","))


    // 水果中包含 a 的水果
    val fruits = Array("apple", "tomato", "peach", "watermallon", "berry")
    val noAFruits = fruits.filter(x => (x.contains('a')))
    println(noAFruits.mkString(","))


    //判断fruits是否包含长度为5 的水果
    val is5Fruits = fruits.exists(x => (x.length == 5))
    println(is5Fruits)


  }

  //定义一个函数, 接受一个数组, 函数把这个数组的两两相邻的元素
  //调换位置
  def pairRevertArray(array: Array[Int]) = {
    for (i <- 0 until(array.length - 1, 2)) {
      val tmp = array(i)
      array(i) = array(i + 1)
      array(i + 1) = tmp
    }
  }

  //定义冒泡排序算法
  // 2,1,4,3,6,5,8,7,9
  // 01 12 23 34
  // 01 12 23
  // 01 12
  // 01
  def bubbleSort(array: Array[Int]) = {
    for (i <- 0 until array.length - 1; j <- 0 until array.length - 1 - i) {
      if (array(j) > array(j + 1)) {
        val tmp = array(j)
        array(j) = array(j + 1)
        array(j + 1) = tmp
      }
    }
    array
  }


  //定义选择排序算法
  // 0 1 2 3 4
  // 01 02 03 04
  //    12 13 14
  //       23 24
  //          34
  def selectSort(array: Array[Int]) = {
    for (i <- 0 until array.length - 1) {
      for (j <- i + 1 until array.length) {
        if (array(i) > array(j)) {
          val tmp = array(i)
          array(i) = array(j)
          array(j) = tmp
        }
      }
    }
  }

  def chooseSort(array: Array[Int]) = {
    for (i <- 0 until array.length - 1; j <- i + 1 until array.length) {
      if (array(i) > array(j)) {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
      }
    }
  }


  // 定义一个函数, 接受一个整数N, 函数返回
  // 一个具有N个元素的数组,
  // 每个位置处的数值是0~N之间的随机数
  def generateRandomArray(n: Int) = {
    val result = new Array[Int](n)
    val random = new Random()
    for (x <- 0 until result.length) {
      result(x) = random.nextInt(n)
    }
    result
  }

  // 定义一个函数, 接受一个整数N, 函数返回
  // 一个具有N个元素的数组,
  // 每个位置处的数值是0~N之间的随机数
  def getRandomArrayN(x: Int) = {
    val array = new Array[Int](x)
    val random = new Random()

    /*for(i <- 0 until array.length){
    println(array(i))
  }*/

    for (i <- 0 until array.length) {
      array(i) = random.nextInt(10)
    }
    println(array.mkString(","))

  }


}
