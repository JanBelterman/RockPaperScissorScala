package RockPaperScissors

import RockPaperScissors.Move.Move
import RockPaperScissors.Result.Result

class Game(player1: Player, player2:Player) {
  private var scorePlayer1, scorePlayer2 = 0

  def getScorePlayer1(): Int = scorePlayer1
  def getScorePlayer2(): Int = scorePlayer2

  def playTurn(): TurnResult = {
    val movePlayer1 = player1.getMove()
    val movePlayer2 = player2.getMove()

    val result = getResult(movePlayer1, movePlayer2)

    result match {
      case Result.PLAYER1_WON => scorePlayer1 += 1
      case Result.PLAYER2_WON => scorePlayer2 += 1
      case Result.TIE => {}
    }

    TurnResult(movePlayer1, movePlayer2, result)
  }

  private def getResult(movePlayer1: Move, movePlayer2: Move): Result = {
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
}
