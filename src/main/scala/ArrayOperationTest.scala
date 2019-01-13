package main.scala

import scala.collection.mutable.ArrayBuffer

object ArrayOperationTest {
  def main(args: Array[String]): Unit = {

    //提供初始值时不要使用new,复杂对象数组没有提供初始值时必须提供new
    val arr1 = new Array[Int](10)
    val arr2 = new Array[String](10)
    val arr3 = Array("bob", "jack", "mach")
    println(arr1.mkString(","))
    println(arr2.mkString(","))
    println(arr3.mkString(","))

    //用()来访问元素
    println(arr3(1))

    //用for(elem <- arr)来遍历数组
    for (item <- arr3) {
      println(item)
    }

    //用for(elem <- arr if...)...yield...来将原数组转型为新数组
    val ans = for (item <- arr1) yield item + 1
    println(ans.mkString(","))

    val ans2 = arr1.filter(_ % 2 == 0).map(_ + 1)
    println(ans2.mkString(","))

    //若长度固定则使用Array,若长度可能有 变化则使用ArrayBuffer
    val b = ArrayBuffer[Int]()
    b += 1
    println(b.mkString(","))
    b += (1, 2, 3, 4)
    println(b.mkString(","))
    b.insert(2, 5)
    println(b.mkString(","))
    b.trimEnd(1)
    println(b.mkString(","))
    for (i <- 0 until b.length) {
      println(i + ":" + b(i))
    }

    //常用api sort
    val b2 = ArrayBuffer[Int](1, 1, 4, 0)
    val sb = b2.sorted
    sb.foreach(print(_))
    println()

    val sb2 = b2.sorted.reverse
    sb2.foreach(print(_))
    println()

    //多维数组
    val matrix1 = Array.ofDim[Int](3, 4)
    println(matrix1(0)(0))

    val triangle = new Array[Array[Int]](3)
    for (i <- 0 until triangle.length) {
      triangle(i) = new Array[Int](i + 1)
    }

    val matrix2 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    for (i <- matrix2) {
      println(i.mkString(","))
    }
    for (i <- matrix2; from = i; j <- from) {
      print(j)
    }


  }

}
