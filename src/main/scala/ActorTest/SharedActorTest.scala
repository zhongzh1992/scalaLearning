package main.scala.ActorTest

import akka.actor.{Actor, ActorRef, ActorSystem, Props}


class AddActor extends Actor {
  override def receive: Receive = {
    case (n1: Int, n2: Int, actor: ActorRef) => actor ! (n1 + n2)
  }
}

class MasterActor extends Actor {
  override def receive: Receive = {
    case sum => println(sum)
  }
}

object SharedActorTes extends App {
  val system: ActorSystem = ActorSystem("helloAkka")
  val addActor: ActorRef = system.actorOf(Props[AddActor], "addActor")
  val masterActor: ActorRef = system.actorOf(Props[MasterActor], "masterActor")
  addActor ! (1, 9, masterActor)
}
