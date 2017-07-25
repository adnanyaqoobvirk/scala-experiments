package org.yaqoob.scala.hackerearth

import scala.io.StdIn

//Given a number N, print the number of set bits in the binary representation of this number.
//
//Input:
//The first contains a single integer T denoting the number of test cases. Each test case contains a single integer N
//
//Output:
//For each test case, print a single integer denoting the number of set bits in the binary representation of the given N

object CountBits extends App {
  def countBits(n: Int, count: Int = 0): Int = n match {
    case 0 => count
    case _ => countBits(n & (n - 1), count + 1)
  }

  def repeat(count: Int): Unit = count match {
    case 0 =>
    case _ =>
      println(countBits(StdIn.readInt()))
      repeat(count - 1)
  }

  repeat(StdIn.readInt())
}
