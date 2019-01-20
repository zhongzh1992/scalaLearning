package main.scala.ActorTest

import akka.actor.{Actor, ActorRef, Props}

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  //#greeter-messages
  final case class WhoToGreet(who: String)

  case object Greet

}

class Greeter(who: String, printerActor: ActorRef) extends Actor {

  import Greeter._
  import Printer._

  var greeting = ""

  def receive = {
    case WhoToGreet(message) =>
      greeting = s"$who[$message]"
    case Greet =>
      //#greeter-send-message
      //给printer行为者发送消息：greeting内容
      printerActor ! Greeting(greeting)
    //#greeter-send-message
  }
}
