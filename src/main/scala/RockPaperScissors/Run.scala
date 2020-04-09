package RockPaperScissors

object Run {

  def main(args: Array[String]): Unit = {
    val game = new Game(Players.createScriptedAI(List(Move.ROCK, Move.ROCK, Move.SCISSORS, Move.PAPER)), Players.createStaticAI(Move.PAPER), Rules.classicRules)

    println("Starting Rock Paper Scissors Game")
    gameLoop(game)
  }

  @scala.annotation.tailrec
  def gameLoop(game: Game): Unit = {
    val turnResult = game.playTurn()

    println("Player 1: " + turnResult.movePlayer1)
    println("Player 2: " + turnResult.movePlayer2)
    println("Result: " + turnResult.result)
    println("Score: " + game.getScorePlayer1() + "-" + game.getScorePlayer2())

    println("Keep playing? Y/N")
    scala.io.StdIn.readLine() match {
      case "N" =>
      case _ => gameLoop(game)
    }
  }

}
