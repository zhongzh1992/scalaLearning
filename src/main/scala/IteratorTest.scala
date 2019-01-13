package main.scala

object IteratorTest {
  def main(arg: Array[String]): Unit = {
    val it1 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    //长度 size / length
    println(it1.size)
    println(it1.length)
    while (it1.hasNext) {
      println(it1.next())
    }
    println(it1.size)
    println(it1.length)
    //判断是否包含contain  注意：！！！调用过contains方法后，迭代器元素个数会变
    val it2 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val isContain = it2.contains(5)
    println(isContain)
    println(it2.size)

    //统计count
    val it3 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val count = it3.count(_ < 5)
    println(count)

    //过滤filter
    val it4 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val fIter = it4.filter(_ < 5)
    fIter.foreach(print(_))
    println()

    //返回丢弃前n个元素后的新集合 drop
    val it5 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val dIter = it5.drop(5)
    dIter.foreach(print(_))
    println()

    //转换为字符串 toString  mkString addString
    val it6 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    println(it6.toString())
    println(it6.mkString(","))
    val it7 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val b = new StringBuilder("123")
    it7.addString(b, ";")
    println(it7)

    //查找第一个满足条件的元素 find
    val it8 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val obj = it8.find(x => x > 7)
    println(obj)

    //下标indexOf   注意：！！！使用该方法后，迭代器会越过这个元素
    val it9 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val e = it9.indexOf(8)
    println(e)

    //map
    val it10 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val mIter = it10.map(x => x + 100)
    mIter.foreach(print(_))
    println()

    //返回前 n 个元素的新迭代器
    val it11 = Iterator(1, 9, 5, 6, 3, 2, 7, 8, 4, 4)
    val tIter = it11.take(3)
    tIter.foreach(print(_))
    println()

    //返回一个新迭代器，指向分别由迭代器和指定的迭代器 that 元素一一对应而成的二元组序列 zip
    val it12 = Iterator(1, 9, 5)
    val name = Iterator("google","baidu","360")
    val pair = it12.zip(name)
    pair.foreach(print(_))
  }
}


