package RockPaperScissors

import RockPaperScissors.AI.RandomAI

object Run {

  def main(args: Array[String]): Unit = {
    val player1 = new ConsolePlayer()
    val player2 = new RandomAI
    val game = new Game(player1, player2)

    var keepPlaying = true

    println("Starting Rock Paper Scissors Game")

    while(keepPlaying){
      val turnResult = game.playTurn()
      println("Player 1: " + turnResult.movePlayer1)
      println("Player 2: " + turnResult.movePlayer2)
      println("Result: " + turnResult.result)
      println("Score: " + game.getScorePlayer1() + "-" + game.getScorePlayer2())

      println("Keep playing? Y/N")
      val response =  scala.io.StdIn.readLine()
      if(response == "N")
        keepPlaying = false
    }
  }
}
