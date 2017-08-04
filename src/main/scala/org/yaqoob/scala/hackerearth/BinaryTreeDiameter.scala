package org.yaqoob.scala.hackerearth

import scala.io.StdIn

class BTree(var value: Any = null, var left: BTree = null, var right: BTree = null)

object BinaryTreeDiameter extends App {
  val Array(numNodes, rootValue) = StdIn.readLine.split(" ").map(_.toInt)
  val rootNode = new BTree(rootValue)

  def addNode(rootNode: BTree, nodeValue: Any, nodePath: String): Unit = {
    var node = rootNode
    nodePath.foreach {
      nodeType =>
        nodeType.toUpper match {
          case 'L' =>
            if (node.left == null)
              node.left = new BTree
            node = node.left
          case 'R' =>
            if (node.right == null)
              node.right = new BTree
            node = node.right
        }
    }
    node.value = nodeValue
  }

  def findDepth(rootNode: BTree): Int = rootNode match {
    case null => 0
    case _ =>
      val leftDepth = findDepth(rootNode.left)
      val rightDepth = findDepth(rootNode.right)

      Vector(leftDepth, rightDepth).max + 1
  }

  def findDiameter(rootNode: BTree): Int = rootNode match {
    case null => 0
    case _ =>
      val leftDepth = findDepth(rootNode.left)
      val rightDepth = findDepth(rootNode.right)

      val leftDiameter = findDiameter(rootNode.left)
      val rightDiameter = findDiameter(rootNode.right)

      Vector(leftDepth + rightDepth + 1, leftDiameter, rightDiameter).max
  }

  (1 until numNodes).foreach {
    _ =>
      val nodePath = StdIn.readLine
      val nodeValue = StdIn.readInt
      addNode(rootNode, nodeValue, nodePath)
  }

  println(findDiameter(rootNode))
}
