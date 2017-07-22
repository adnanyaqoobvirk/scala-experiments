package org.yaqoob.scala.hackerearth

import scala.io.StdIn

object CountDigits {
  def main(args: Array[String]) {
    val line = StdIn.readLine()
    val digitMap = line.groupBy(char => char).mapValues(_.length)
    "0123456789".foreach(digit => println(s"$digit ${digitMap.getOrElse(digit, 0)}"))
  }
}
