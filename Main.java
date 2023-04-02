import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    char[][] board = new char[3][3];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        board[r][c] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner sc = new Scanner(System.in);

    while (!gameOver) {
      printBoard(board);
      System.out.println("player " + player + " enter");
      int r = sc.nextInt();
      int c = sc.nextInt();
      System.out.println();

      if (board[r][c] == ' ') {
        board[r][c] = player; // place the element
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("Player " + player + " has won: ");
        } else {
          // if(player == 'X') {
          // player = '0';
          // }else{
          // player = 'X';
          // }
          player = (player == 'X') ? 'O' : 'X';
        }
      } else {
        System.out.println("Invaild move. try again!");
      }
    }
    printBoard(board);
  }

  public static void printBoard(char[][] board) {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        System.out.print(board[r][c] + " | ");
      }
      System.out.println();
    }
  }

  public static boolean haveWon(char[][] board, char player) {

    for (int r = 0; r < board.length; r++) {
      // checking the rows
      if (board[r][0] == player && board[r][1] == player && board[r][2] == player) {
        return true;
      }
    }
    // checking the col
    for (int c = 0; c < board.length; c++) {
      if (board[0][c] == player && board[1][c] == player && board[2][c] == player) {
        return true;
      }
    }

    // diagonal
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
      return false;
  }
}