package main.scala.ActorTest

import akka.actor.{Actor, Props}

//#printer-companion
//#printer-messages
object Printer {
  //#printer-messages
  def props: Props = Props[Printer]
  //#printer-messages
  final case class Greeting(greeting: String)
}
//#printer-messages
//#printer-companion

//#printer-actor
class Printer extends Actor {
  import Printer._

  def receive = {
    case Greeting(greeting) =>
      println(s"Greeting received (from ${sender}): $greeting")
  }
}
//#printer-actor
