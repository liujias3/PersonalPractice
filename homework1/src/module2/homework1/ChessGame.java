package module2.homework1;

import java.util.Scanner;

public class ChessGame {
    private Player currentPlayer;
    private char[][] checkerboard;
    private int cnt;
    private char[] coordinate = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //enum class for the player
    enum Player{
        WHITE, BLACK
    }

    public ChessGame() {
        checkerboard = setInitialBoard();
        cnt = 0;

        // default set black go first
        currentPlayer = Player.BLACK;
        printBoard();
    }

    public void play(){
        //cnt is count for the case board is full we will start the new game
        cnt++;

        char x;
        char y;
        int convertedX = 0;
        int convertedY = 0;

        //loop the input until get a valid input
        while(true){
            System.out.println(currentPlayer.toString() + " player please choose the coordinate you want play(two num are required x,y choose the coordinate on the board, example(1 f)): ");
            Scanner sc = new Scanner(System.in);
            x = sc.next().charAt(0);
            y = sc.next().charAt(0);
            if( checkInput(x) && checkInput(y)){
                convertedX = convertInput(x);
                convertedY = convertInput(y);
                //since we have a leading empty space so add one for x and y
                convertedX += 1;
                convertedY += 1;
                //validate whether the spot is being placed
                // important reminder here the reason why put Y in the row and x in the col is
                // people set the x and y as x for horizontal and y for vertical but in the coding
                // we need use the horizontal for the row and  vertical for the col
                if(checkerboard[convertedY][convertedX] != '+'){
                    System.out.println("This spot is been placed already");
                }else{
                    //success get out the loop
                    break;
                }
            }else{
                //invalid input x or y out of range of(0-9, a-f)
                System.out.println("Invalid Character input please choose the num for 0-9 or char a-f");
            }
        }


        //Black is x and White is o
        if(currentPlayer == Player.BLACK)
            checkerboard[convertedY][convertedX] ='x';
        else
            checkerboard[convertedY][convertedX] ='o';

        //print the board for after chess placed
        printBoard();

        //do the winner check for current spot
        if(winnerCheck(convertedX, convertedY)){
            System.out.println("Winner is " + currentPlayer);
        } else{
            //if not win switch player and keep playing
            switchPlayer();
            if(cnt == 256){
                checkerboard = setInitialBoard();
            }
            play();
        }
    }

    private boolean winnerCheck(int x, int y){
        // the basic idea for check the winner is start from the point check for the vertical, horizontal , LTRB and RTLB four directions
        //for example for the vertical start from the point go all the way up then all the way down to count the connective current Player chess
        //also validate if the chess is out of the board
        int tempX = x;
        int tempY = y;
        char currentChar = 0;
        // set the current player
        if(currentPlayer == Player.BLACK)
            currentChar = 'x';
        else
            currentChar = 'o';

        int vertical = 0;
        int horizontal = 0;

        //LTRB means from LEFT Top to Right Bottom  RTLB means Right Top to Left Bottom
        int LTRB = 0;
        int RTLB = 0;

        //all the way right exlain the reason why Y and X is reverted above
        while(validXY(tempX, tempY) && checkerboard[tempY][++tempX] == currentChar){
            horizontal++;
        }

        // back to the given spot
        tempX = x;
        tempY = y;

        //all the way left
        while(validXY(tempX, tempY) && checkerboard[tempY][--tempX] == currentChar){
            horizontal++;
        }

        // the reason why we only need to check for equal 4 is the given spot is also a chess so include in that one player win
        if(horizontal >= 4){
            return true;
        }


        tempX = x;
        tempY = y;

        //all the way up
        while(validXY(tempX, tempY) && checkerboard[--tempY][tempX] == currentChar){
            vertical++;
        }
        tempX = x;
        tempY = y;

        //all the way down
        while(validXY(tempX, tempY) && checkerboard[++tempY][tempX] == currentChar){
            vertical++;
        }

        if(vertical >= 4){
            return true;
        }


        tempX = x;
        tempY = y;

        //left top to the given chess
        while(validXY(tempX, tempY) && checkerboard[--tempY][--tempX] == currentChar){
            LTRB++;
        }
        tempX = x;
        tempY = y;

        //given chess to the right bottom
        while(validXY(tempX, tempY) && checkerboard[++tempY][++tempX] == currentChar){
            LTRB++;
        }

        if(LTRB >= 4){
            return true;
        }

        tempX = x;
        tempY = y;

        //right top to the given chess
        while(validXY(tempX, tempY) && checkerboard[--tempY][++tempX] == currentChar){
            RTLB++;
        }

        tempX = x;
        tempY = y;

        //given chess to the left bottom
        while(validXY(tempX, tempY) && checkerboard[++tempY][--tempX] == currentChar){
            RTLB++;
        }

        if(RTLB >= 4){
            return true;
        }

        return false;
    }

    private boolean validXY(int x, int y){
        //validate the chess is in the board or not
        return ( (x >= 1 && x <= 16) &&  (y >= 1 && y <= 16));
    }

    private void switchPlayer(){
        if(currentPlayer == Player.BLACK)
            currentPlayer = Player.WHITE;
        else
            currentPlayer = Player.BLACK;
    }

    private boolean checkInput(char c){
        // check the input is valid or not
        return ( (c >='0' && c <= '9') || (c >= 'a' && c <= 'f'));
    }

    private int convertInput(char c) {
        //if character is int convert char to int
        if ((c >='0' && c <= '9')) {
            return Character.getNumericValue(c);
        }else{
            //set the ASCII to num
            return c - 87;
        }
    }

    private char[][] setInitialBoard(){
        //set the board as all +
        char[][] board =  new char[17][17];

        //set left top corner to empty char since there is nothing over there
        board[0][0] = ' ';

        //set the first row
        for(int i = 1; i <= coordinate.length; i++){
            board[0][i] = coordinate[i-1];
        }

        //set the first col
        for(int i = 1; i <= coordinate.length; i++){
            board[i][0] = coordinate[i-1];
        }

        //set the rest of the board
        for(int i = 1;i <= coordinate.length; i++){
            for(int j = 1; j <=coordinate.length; j++){
                board[i][j] = '+';
            }
        }
        return board;
    }

    private void printBoard(){
        // print the board
        System.out.println("         Current Check Board");
        System.out.println("         Black is x and White is o");

        for(char[] c:checkerboard){
            for(char ch:c){
                System.out.print(ch + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.play();
    }
}
