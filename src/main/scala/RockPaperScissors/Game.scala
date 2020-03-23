package RockPaperScissors

import RockPaperScissors.Move.Move
import RockPaperScissors.Result.Result

class Game(player1Move: (List[TurnResult]) => Move,
           player2Move: (List[TurnResult]) => Move,
           ruleStrategy: (Move, Move) => Result) {

  private var turnHistory: List[TurnResult] = List()
  private var scorePlayer1, scorePlayer2 = 0

  def getScorePlayer1(): Int = scorePlayer1
  def getScorePlayer2(): Int = scorePlayer2

  def playTurn(): TurnResult = {
    val movePlayer1 = player1Move(turnHistory)
    val movePlayer2 = player2Move(turnHistory.map(turnResult => turnResult.invert()))

    val result = ruleStrategy(movePlayer1, movePlayer2)

    result match {
      case Result.PLAYER1_WON => scorePlayer1 += 1
      case Result.PLAYER2_WON => scorePlayer2 += 1
      case Result.TIE =>
    }

    val turnResult: TurnResult = TurnResult(movePlayer1, movePlayer2, result)
    turnHistory = turnResult::turnHistory
    turnResult
  }
}
