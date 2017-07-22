package org.yaqoob.scala.hackerearth

import scala.io.StdIn

object IOTest {
  def main(args: Array[String]): Unit = {
    val num = StdIn.readInt()
    val str = StdIn.readLine()
    println(s"${num * 2}")
    println(str)
  }
}