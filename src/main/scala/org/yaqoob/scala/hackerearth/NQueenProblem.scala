package org.yaqoob.scala.hackerearth

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

// N-Queens Problem: Given a chess board having N × N cells, we need to place N queens in such a way that no queen is
// attacked by any other queen. A queen can attack horizontally, vertically and diagonally.
//
// So initially we are having N × N unattacked cells where we need to place N queens. Let's place the first queen at a
// cell(i,j), so now the number of unattacked cells is reduced, and number of queens to be placed is N − 1. Place the
// next queen at some unattacked cell. This again reduces the number of unattacked cells and number of queens to be
// placed becomes N − 2. Continue doing this, as long as following conditions hold.
//
// 1. The number of unattacked cells is not 0.
// 2. The number of queens to be placed is not 0.

object NQueenProblem extends App {

  val N = StdIn.readInt()
  var board = ArrayBuffer.empty[ArrayBuffer[Int]]

  def isAttacked(x: Int, y: Int, board: ArrayBuffer[ArrayBuffer[Int]]): Boolean = {
    val xPlusY = x + y
    val xMinusY = x - y
    for (i <- board.indices) {
      if (board(x)(i) == 1 || board(i)(y) == 1)
        return true

      for (j <- board.indices)
        if ((i + j == xPlusY && board(i)(j) == 1) || (i - j == xMinusY && board(i)(j) == 1))
          return true
    }

    false
  }

  def placeQueens(board: ArrayBuffer[ArrayBuffer[Int]], N: Int): Option[ArrayBuffer[ArrayBuffer[Int]]] = N match {
    case 0 => Option(board)
    case _ =>
      for (i <- board.indices)
        for (j <- board.indices)
          if (!isAttacked(i, j, board)) {
            board(i).update(j, 1)
            val resultBoard = placeQueens(board, N - 1)
            if (resultBoard.isDefined)
              return resultBoard
            board(i).update(j, 0)
          }

      None
  }

  for (i <- 0 until N) board += ArrayBuffer.fill(N)(0)

  placeQueens(board, N) match {
    case None => println("NO")
    case Some(resultBoard) =>
      println("YES")
      resultBoard.map(_.map(i => s"$i ").reduce(_ + _).trim).foreach(println)
  }

}
