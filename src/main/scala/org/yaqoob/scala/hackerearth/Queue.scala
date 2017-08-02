package org.yaqoob.scala.hackerearth

import scala.collection.mutable
import scala.io.StdIn

//You have to perform N operations on a queue of the following types:

//E x : Enqueue x in the queue and print the new size of the queue.
//D : Dequeue from the queue and print the element that is deleted and the new size of the queue separated by a space.
//If there is no element in the queue, then print −1 in place of the deleted element.
//
//Input format
//First line: N
//Next N lines: One of the above operations
//
//Output format
//Enqueue operation: Print the new size of the queue
//Dequeue operation: Print two integers, the deleted element and the new size of the queue.
//If the queue is empty, print −1 and the new size of the queue.

object Queue extends App {
  val queue = new mutable.ArrayBuffer[String]
  val operationsSize = StdIn.readInt
  (1 to operationsSize).foreach {
    _ =>
      val operation = StdIn.readLine.split(" ")
      operation(0) match {
        case "D" =>
          if (queue.isEmpty)
            println(s"-1 0")
          else
            println(s"${queue.remove(0)} ${queue.length}")
        case "E" =>
          queue.append(operation(1))
          println(queue.length)
      }
  }
}
