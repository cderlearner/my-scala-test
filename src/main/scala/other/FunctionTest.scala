package other

import java.util.Random

object FunctionTest {

  def plusInt(x: Int, y: Int) = {
    println(s"调用函数plusInt, 结果值: ${x + y}")
    x + y
  }

  val plusIntVal: (Int, Int) => Int = (x, y) => x + y

  def preducePlus(x: Int, y: Int) = {
    println(s"调用过程preducePlus, 结果值: ${x + y}")
    x + y
  }

  //定义一个函数, 函数随机
  def getRandomN(n: Int) = {
    val random = new Random()
    random.nextInt(n)
  }

  //这个函数的类型是什么
  // 用val 函数类和字面量的方法重新定义这个函数, 函数的名称: getRandomN1
  // val plusIntVal : (Int,Int) => Int=(x,y) => x+y
  val getRandomN1: (Int) => Int = (n: Int) => {
    val random = new Random()
    random.nextInt(n)
  }


  //圆的面积(Int) => Double
  val randomArea = (r: Int) => {
    println(s"计算圆的面积: ${3.14 * r * r}")
    3.14 * r * r
  }


  //正方体的面积函数
  val squareArea = (l: Int) => {
    println(s"计算正方体的面积: ${l * l * 1.00}")
    l * l * 1.00
  }


  //计算扇形的面积, 计算无限种面积的能力
  //函数, 这个函数可以接受一个参数(边长或半径), 然我们可以调用这个函数的时候决定是求
  // 圆面积还是求正方体的面积
  def caculateArea(x: Int, f: (Int) => Double) = {
    f(x)
  }

  def main(args: Array[String]): Unit = {

    //    val functionResult = plusInt(5,6)
    //    val preduceResult = preducePlus(5,6)
    //    println(s"functionResult: $functionResult")
    //    println(s"preduceResult: $preduceResult")
    //
    //    println(plusIntVal)
    //    println(plusIntVal(5,6))

    println(getRandomN(10))
    println(getRandomN1(10))

    //计算面积
    caculateArea(4, randomArea)
    caculateArea(4, squareArea)

    //计算等边三角形的面积
    caculateArea(4, x => {
      println(s"等边三角形的面积: ${x * x * scala.math.sqrt(3) / 4}")
      x * x * scala.math.sqrt(3) / 4
    })

  }
}
