package main.scala.ActorTest

import akka.actor.{ActorRef, ActorSystem}

object AkkaQuickstart extends App {

  import Greeter._

  // Create the 'helloAkka' actor system
  //使用akka包创建actor通信系统
  val system: ActorSystem = ActorSystem("helloAkka")

  //#create-actors
  // Create the printer actor
  //创建printer行为者，第一个参数为printer类属性引用，第二个参数为actor名称
  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

  // Create the 'greeter' actors
  //创建三个不同名称的Greeter行为者，第一个参数为Greeter类属性引用，第二个参数为actor名称
  val howdyGreeter: ActorRef =
    system.actorOf(Greeter.props("Howdy", printer), "howdyGreeter")
  val helloGreeter: ActorRef =
    system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
  val goodDayGreeter: ActorRef =
    system.actorOf(Greeter.props("Good day", printer), "goodDayGreeter")
  //#create-actors

  //#main-send-messages
  //给howdyGreeter行为者发送消息："Akka"
  howdyGreeter ! WhoToGreet("Akka")
  //给howdyGreeter行为者发送消息：执行打印
  howdyGreeter ! Greet

  //同上
  howdyGreeter ! WhoToGreet("Lightbend")
  howdyGreeter ! Greet

  //同上
  helloGreeter ! WhoToGreet("Scala")
  helloGreeter ! Greet

  //同上
  goodDayGreeter ! WhoToGreet("Play")
  goodDayGreeter ! Greet
  //#main-send-messages
}
