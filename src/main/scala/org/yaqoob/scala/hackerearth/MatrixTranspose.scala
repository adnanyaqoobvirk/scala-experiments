package org.yaqoob.scala.hackerearth

import scala.io.StdIn

object MatrixTranspose extends App {
  val Array(rows, cols) = StdIn.readLine.split(" ").map(_.toInt)
  val matrix = (0 until rows).map(_ => StdIn.readLine).map(_.split(" ").map(_.toInt)).toArray
  (0 until cols).foreach(i => println(matrix.map(row => s"${row(i)} ").reduce(_ + _).trim))
}
