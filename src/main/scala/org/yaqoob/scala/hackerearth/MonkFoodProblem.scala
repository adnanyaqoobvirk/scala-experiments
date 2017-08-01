package org.yaqoob.scala.hackerearth

import scala.collection.mutable
import scala.io.StdIn

//Input:
//First line contains an integer Q, the number of queries. Q lines follow.
//A Type-1 ( Customer) Query, is indicated by a single integer 1 in the line.
//A Type-2 ( Chef) Query, is indicated by two space separated integers 2 and C (cost of the package prepared) .
//
//Output:
//For each Type-1 Query, output the price that customer has to pay i.e. cost of the package given to the customer in a new line. If the pile is empty, print "No Food" (without the quotes).

private object MonkFoodStack {
  private val stack = new mutable.ArrayBuffer[String]

  def pop: String =
    if (stack.isEmpty)
      "No Food"
    else
      stack.remove(stack.size - 1)

  def push(elem: String): Unit = stack.append(elem)

  def length: Int = stack.size

  def isEmpty: Boolean = stack.isEmpty
}

object MonkFoodProblem extends App {
  val numQueries = StdIn.readInt

  (1 to numQueries).foreach {
    _ =>
      val query = StdIn.readLine.split(" ")
      query.length match {
        case 2 =>
          MonkFoodStack.push(query(1))
        case _ =>
          println(MonkFoodStack.pop)
      }
  }
}
