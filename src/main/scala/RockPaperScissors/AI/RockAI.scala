package RockPaperScissors.AI

import RockPaperScissors.Move.Move
import RockPaperScissors.{Move, Player}

class RockAI extends Player {
  override def getMove(): Move = Move.ROCK
}
