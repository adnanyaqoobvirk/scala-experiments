package org.yaqoob.scala.hackerearth

import scala.collection.mutable
import scala.io.StdIn

//Input Format
//The first line contains a single integers N denoting the number of Monk's colleagues. Each of the next N lines contains
//an integer and a String denoting the roll number and name of the i th colleague of Monk. The next Line contains a
//single integer q denoting the number of queries Monk shall present to you when he starts teaching in class. Each of
//the next q lines contains a single integer x denoting the roll number of the student whose name Monk wants to know.
//
//Output Format
//You need to print q Strings, each String on a new line, indicating the answers to each of Monk's queries.

class HashMap(size: Int) {
  private val map: mutable.ArrayBuffer[String] = mutable.ArrayBuffer.fill(size)(null)

  def add(key: Int, value: String): Boolean = {
    var hash = calcHash(key)
    while (hash < size && map(hash) != null)
      hash = hash + 1

    if (hash < size && map(hash) == null) {
      map(hash) = value
      true
    }
    else false
  }

  private def calcHash(key: Int): Int = key % size

  def get(key: Int): String = {
    var hash = calcHash(key)
    while (hash < size && map(hash) == null)
      hash = hash + 1

    if (hash < size)
      map(hash)
    else
      null
  }
}

object NameLookup extends App {
  val numNames = StdIn.readInt
  val namesMap = new HashMap(numNames)
  (1 to numNames).foreach {
    _ =>
      val Array(k, v) = StdIn.readLine.split(" ")
      namesMap.add(k.toInt, v)
  }

  val numQueries = StdIn.readInt
  (1 to numQueries).foreach(_ => println(namesMap.get(StdIn.readInt)))
}
