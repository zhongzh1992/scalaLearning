package main.scala

object ScalaMatchTest {

  def main(args: Array[String]): Unit = {
    val ans1 = matchNumber(1)
    println(ans1)

    val ans2 = matchNumber("three")
    println(ans2)

    val ans3 = matchNumber(5)
    println(ans3)

    getGrade("Jack")
  }

  def matchNumber(x: Any) = x match {
    case 1 => "one"
    case 2 => "two"
    case "three" => 3
    case y: Int => "scala.Int"
    case _ => "many"
  }

  def getGrade(name: String) {
    val grades = Map("Leo" -> "A", "Jack" -> "B", "Jen" -> "C")
    val grade = grades.get(name)
    grade match {
      case Some(grade) => println("your grade is " + grade)
      case None => println("Sorry, your grade information is not in the system")
    }
  }
}
