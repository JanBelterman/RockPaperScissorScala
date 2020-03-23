package RockPaperScissors

import RockPaperScissors.Move.Move
import RockPaperScissors.Result.Result

object Rules {

  def classicRules(movePlayer1: Move, movePlayer2: Move): Result = {
    val result = movePlayer1 match {
      case RockPaperScissors.Move.ROCK => movePlayer2 match {
        case RockPaperScissors.Move.ROCK => Result.TIE
        case RockPaperScissors.Move.PAPER => Result.PLAYER2_WON
        case RockPaperScissors.Move.SCISSORS => Result.PLAYER1_WON
      }
      case RockPaperScissors.Move.PAPER => movePlayer2 match {
        case RockPaperScissors.Move.ROCK => Result.PLAYER1_WON
        case RockPaperScissors.Move.PAPER => Result.TIE
        case RockPaperScissors.Move.SCISSORS => Result.PLAYER2_WON
      }
      case RockPaperScissors.Move.SCISSORS => movePlayer2 match {
        case RockPaperScissors.Move.ROCK => Result.PLAYER2_WON
        case RockPaperScissors.Move.PAPER => Result.PLAYER1_WON
        case RockPaperScissors.Move.SCISSORS => Result.TIE
      }
    }
    result
  }

  def predictRules(movePlayer1: Move, movePlayer2: Move): Result = {
    if (movePlayer1 == movePlayer2) {
      Result.PLAYER1_WON
    } else {
      Result.PLAYER2_WON
    }
  }

}
