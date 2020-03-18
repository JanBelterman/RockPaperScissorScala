package RockPaperScissors.AI

import RockPaperScissors.Move.Move
import RockPaperScissors.{Move, Player}

class RandomAI extends Player{
  val rand = scala.util.Random

  override def getMove(): Move = {
    val randomInt = rand.nextInt(3)

    randomInt match {
      case 0 => Move.ROCK
      case 1 => Move.PAPER
      case 2 => Move.SCISSORS
      case _ => throw new IllegalStateException("The random value was " + randomInt + " but should be 0, 1 or 2")
    }
  }

}
