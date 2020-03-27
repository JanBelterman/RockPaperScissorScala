package RockPaperScissors

object Run {

  def main(args: Array[String]): Unit = {
    val game = new Game(Players.getConsolePlayerMove, Players.getLastSuccessfulMove, Rules.classicRules)

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
    val response =  scala.io.StdIn.readLine()
    if(response == "N") { }
    else { gameLoop(game) }
  }

}
