package RockPaperScissors

import RockPaperScissors.Move.Move

trait Player {
  def getMove(): Move
}
