package org.yaqoob.scala.hackerearth

import scala.io.StdIn

//Given a 2D array A, your task is to convert all rows to columns and columns to rows.
//
//Input:
//First line contains 2 space separated integers, N - total rows, M - total columns.
//Each of the next N lines will contain M space separated integers.
//
//Output:
//Print M lines each containing N space separated integers.

object MatrixTranspose extends App {
  val Array(rows, cols) = StdIn.readLine.split(" ").map(_.toInt)
  val matrix = (0 until rows).map(_ => StdIn.readLine).map(_.split(" ").map(_.toInt)).toArray
  (0 until cols).foreach(i => println(matrix.map(row => row(i)).mkString(" ")))
}
