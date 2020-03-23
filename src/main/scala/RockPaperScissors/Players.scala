package RockPaperScissors

import RockPaperScissors.Move.Move

object Players {

  def getRandomAIMove(turnHistory: List[TurnResult]): Move = {
    val randomInt = scala.util.Random.nextInt(3)

    randomInt match {
      case 0 => Move.ROCK
      case 1 => Move.PAPER
      case 2 => Move.SCISSORS
      case _ => throw new IllegalStateException("The random value was " + randomInt + " but should be 0, 1 or 2")
    }
  }

  def getRockAIMove(turnHistory: List[TurnResult]): Move = {
    Move.ROCK
  }

  def getConsolePlayerMove(turnHistory: List[TurnResult]): Move = {
    val validMove = false;

    while(!validMove){

      println("Your turn. Choose ROCK, PAPER or SCISSORS")
      val input = scala.io.StdIn.readLine()
      input match {
        case "ROCK" => return Move.ROCK
        case "PAPER" => return Move.PAPER
        case "SCISSORS" => return Move.SCISSORS
        case _ =>
      }
    }
    throw new IllegalStateException("Should not be able to exit the while loop")
  }

  def getMirrorAIPlayerMove(turnHistory: List[TurnResult]): Move = {
    val head::_ = turnHistory
    if (head == null) {
      getRandomAIMove(turnHistory)
    } else {
      head.movePlayer2
    }
  }

  def getCounterAIPlayerMove(turnHistory: List[TurnResult]): Move = {
    if (turnHistory.isEmpty) {
      return getRandomAIMove(turnHistory)
    }
    val head::_ = turnHistory
    if (head == null) {
      getRandomAIMove(turnHistory)
    } else {
      val move: Move = head.movePlayer2 match {
        case Move.ROCK => Move.PAPER
        case Move.PAPER => Move.SCISSORS
        case Move.SCISSORS => Move.ROCK
      }
      move
    }
  }

}
