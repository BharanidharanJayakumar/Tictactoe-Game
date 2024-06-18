import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        char board[][]=new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col]=' ';
            }
        }
        char player='X';
        boolean gameover=false;
        Scanner sc = new Scanner(System.in);
        while(!gameover){
            printboard(board);
            System.out.println("Player "+ player +" play now: ");
            int row = sc.nextInt();
            int col =sc.nextInt();
            System.out.println();
            if(row>2 || col>2){
                System.out.println("Invalid move.Enter values from 0 to 2 only.");
            }
            if(row<3 && col<3) {
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    gameover = checkwin(board, player);
                    if (gameover) {
                        System.out.println("player " + player + " has won\nCogratulations!!");
                    } else {
                        if (player == 'X') {
                            player = '0';
                        } else {
                            player = 'X';
                        }
                    }
                } else {
                    System.out.println("Invalid move.Box is already filled");
                }

            }
        }
    }
    static void printboard(char[][] board){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
    static boolean checkwin(char[][] board,char player){
        for(int i=0;i< board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        for(int col = 0; col < board.length; col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player &&  board[2][2]==player){
            return true;
        }
        if(board[2][0]==player && board[1][1]==player &&  board[0][2]==player){
            return true;
        }
        return false;
    }

}