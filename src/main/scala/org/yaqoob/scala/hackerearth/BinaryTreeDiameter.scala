package org.yaqoob.scala.hackerearth

import scala.io.StdIn

//Given a binary tree which has T nodes, you need to find the diameter of that binary tree. The diameter of a tree is
//the number of nodes on the longest path between two leaves in the tree.
//
//Input:
//First line contains two integers,T and X, number of nodes in the tree and value of the root. Next 2 × (T − 1) lines
//contain details of nodes. Each detail of node contains two lines. First lines contains a string and second line
//contains an integer, which denotes the path of the node and the value of the node respectively. String consists of
//only L or R. L denotes left child and R denotes right child. ( Look at the sample explanation for more details )
//
//Output:
//Print the diameter of the binary tree.

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
