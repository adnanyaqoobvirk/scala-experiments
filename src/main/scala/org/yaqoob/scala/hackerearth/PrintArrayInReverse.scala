package org.yaqoob.scala.hackerearth

import scala.io.StdIn

//Given the size and the elements of array A, print all the elements in reverse order.
//
//Input:
//First line of input contains, N - size of the array.
//Following N lines, each contains one integer, i{th} element of the array i.e. A[i].
//
//Output:
//Print all the elements of the array in reverse order, each element in a new line.

object PrintArrayInReverse extends App {
  val arraySize = StdIn.readInt
  (0 until arraySize).map(_ => StdIn.readInt).reverse.foreach(println)
}
