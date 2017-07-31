package org.yaqoob.scala.hackerearth

import scala.io.StdIn

object PrintArrayInReverse extends App {
  val arraySize = StdIn.readInt
  (0 until arraySize).map(_ => StdIn.readInt).reverse.foreach(println)
}
