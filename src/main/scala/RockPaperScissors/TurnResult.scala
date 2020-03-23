package RockPaperScissors

import RockPaperScissors.Move.Move
import RockPaperScissors.Result.Result

case class TurnResult(movePlayer1: Move, movePlayer2: Move, result: Result) {

  def invert(): TurnResult = {
    val invertedResult: Result = result match {
      case Result.PLAYER1_WON => Result.PLAYER2_WON
      case Result.PLAYER2_WON => Result.PLAYER1_WON
      case _ => Result.TIE
    }
    TurnResult(movePlayer2, movePlayer1, invertedResult)
  }

}
