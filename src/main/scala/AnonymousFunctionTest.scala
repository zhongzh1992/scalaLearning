package main.scala

object AnonymousFunctionTest {

  def main(args: Array[String]): Unit = {
    //第一种匿名函数
    val inc = (x: Int) => (x + 1)
    println(inc(1))

    //第二种匿名形式
    def add1 = new Function1[Int, Int] {
      def apply(x: Int) = x + 1
    }

    println(add1(5))

    //高阶函数
    def greeting() = (name: String) => ("hello," + name)

    println(greeting()("zhongzh"))

    //函数做形参
    def operate(f: (Int, Int) => Int) = {
      f(4, 4)
    }

    def add = (x: Int, y: Int) => (x + y)

    println(operate(add))

    //柯里化  -> 第一个函数的结果作为第二个函数的输入
    def mutil(x: Int)(y: Int) = x * y

    println(mutil(2)(3))
  }


}
