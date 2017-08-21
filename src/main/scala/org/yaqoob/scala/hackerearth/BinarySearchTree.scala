package org.yaqoob.scala.hackerearth

import scala.io.StdIn

//Create a Binary Search Tree from list A containing N elements. Insert elements in the same order as given. Print the
//pre-order traversal of the subtree with root node data equal to Q (inclusive of Q), separating each element by a space.

//Input:
//First line contains a single integer N – number of elements.
//Second line contains N space-separated integers.
//Third line contains a single integer Q – the element whose subtree is to be printed in pre-order form.

//Output:
//Print K space-separated integers – where K is the number of elements in the subtree of Q (inclusive of Q)

case class BinarySearchTree(var value: Int, var leftNode: BinarySearchTree = null, var rightNode: BinarySearchTree = null)

object BinarySearchTree extends App {
  val listSize = StdIn.readInt
  val intList = StdIn.readLine.split(" ").map(_.toInt).toList
  val root = intList.drop(1).foldLeft(new BinarySearchTree(intList.head))((root, value) => insert(root, value))

  def insert(root: BinarySearchTree, value: Int): BinarySearchTree = {
    if (value > root.value) {
      if (root.rightNode == null)
        root.rightNode = new BinarySearchTree(value)
      else
        insert(root.rightNode, value)
    }
    else if (value < root.value) {
      if (root.leftNode == null)
        root.leftNode = new BinarySearchTree(value)
      else
        insert(root.leftNode, value)
    }

    root
  }

  def findNode(root: BinarySearchTree, value: Int): BinarySearchTree =
    if (root == null) null
    else if (root.value == value) root
    else if (root.value > value) findNode(root.leftNode, value)
    else findNode(root.rightNode, value)

  def preOrderTraversal(root: BinarySearchTree): List[Int] =
    if (root != null)
      List(root.value) ::: preOrderTraversal(root.leftNode) ::: preOrderTraversal(root.rightNode)
    else
      Nil

  preOrderTraversal(findNode(root, StdIn.readInt)).foreach(println)
}
