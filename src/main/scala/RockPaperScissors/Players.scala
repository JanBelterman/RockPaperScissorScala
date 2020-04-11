package RockPaperScissors

import RockPaperScissors.Move.Move

object Players {

  def askMoveInConsole(): Option[Move] = scala.io.StdIn.readLine("Your turn. Choose ROCK, PAPER or SCISSORS\n") match {
    case "ROCK" => Some(Move.ROCK)
    case "PAPER" => Some(Move.PAPER)
    case "SCISSORS" => Some(Move.SCISSORS)
    case _ => None
  }

  def getRandomAIMove(turnHistory: List[TurnResult]): Move = {
      scala.util.Random.nextInt(3) match {
      case 0 => Move.ROCK
      case 1 => Move.PAPER
      case 2 => Move.SCISSORS
      case n => throw new IllegalStateException("The random value was " + n + " but should be 0, 1 or 2")
    }
  }

  def createStaticAI(move: Move): (List[TurnResult]) => Move = {
    (turnHistory) => move
  }

  def createScriptedAI(l: List[Move]): (List[TurnResult]) => Move = {
    var moves = l
    (turnHistory) => moves match {
      case h::Nil => h
      case h::t =>
        moves = t
        h
    }
  }

  @scala.annotation.tailrec
  def getConsolePlayerMove(turnHistory: List[TurnResult]): Move = {
    askMoveInConsole() match {
      case Some(move) => move
      case None =>
        println("Wrong input. Try again.")
        getConsolePlayerMove(turnHistory)
    }
  }

  def getMirrorAIPlayerMove(turnHistory: List[TurnResult]): Move = turnHistory match {
    case Nil => getRandomAIMove(turnHistory)
    case h::_ => h.movePlayer2
  }

  def getCounterAIPlayerMove(turnHistory: List[TurnResult]): Move = turnHistory match {
    case Nil => getRandomAIMove(turnHistory)
    case h::_ => h.movePlayer2 match {
      case Move.ROCK => Move.PAPER
      case Move.PAPER => Move.SCISSORS
      case Move.SCISSORS => Move.ROCK
    }
  }

  @scala.annotation.tailrec
  def getLastSuccessfulMove(turnHistory: List[TurnResult]): Move = turnHistory match {
    case Nil => getRandomAIMove(turnHistory)
    case h::_ if (h.result == Result.PLAYER1_WON) => h.movePlayer1
    case _::t => getLastSuccessfulMove(t)
  }

  def applyRandomAI(aiList: List[(List[TurnResult]) => Move], turnHistory: List[TurnResult]): Move = {
      aiList match {
        case Nil => getRandomAIMove(turnHistory)
        case _ => aiList(scala.util.Random.nextInt(aiList.length))(turnHistory)
      }
  }

  def applyRandomAICurried(aiList: List[(List[TurnResult]) => Move])(turnHistory: List[TurnResult]): Move = {
    aiList match {
      case Nil => getRandomAIMove(turnHistory)
      case _ => aiList(scala.util.Random.nextInt(aiList.length))(turnHistory)
    }
  }

}
