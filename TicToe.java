	//Diego Damian
	//Lab 1 - CSC 162-02
	//project starts

package projects;
import java.util.*;

public class TicToe {

	  public static void main(String[] args) {
	    // empty board
	    String [][] board = getBoard();
	    // Create two players token
	    String[] tokens = {" X ", " O "};
	    int result;
	    
	   //Repeat while result is continue
	  do {
	    print(board);
	    int[] cell = getCell(board, tokens[0]);
	    placeToken(board, cell, tokens[0]);
	    result = gameStatus(board, tokens[0]);
	    if(result == 2) {
	      swap(tokens);
	    }
	  }while(result ==2);
	  print(board);
	  if(result == 0)
	    System.out.println(tokens[0] + "PLAYER WON");
	  else
	    System.out.print("PLAYER DRAW");
	}
	// displays the board
	public static void print(String[][] m) {
	  System.out.println("\n-------------");
	  for(int i = 0; i < m.length; i++) {
	    for(int j = 0; j < m.length; j++) {
	      System.out.print("|" + m[i][j]);
	    }
	    System.out.println("|\n-------------");
	} }
	// returns a 3 x 3 array filled with blank spaces
	public static String[][] getBoard(){
	  String[][] m = new String[3][3];
	  for(int i = 0; i < 3; i++) {
	    for(int j = 0; j < 3; j++) {
	      m[i][j] = "    ";
	} }
	return m; }
	//returns true is cell is empty and is in a 3 x 3 array
	public static boolean validCell(String[][] m , int[] cell) {
	  for(int i = 0; i < cell.length; i++) {
	    if(cell[i] < 0 || cell[i] >= 3) {
	      System.out.println("Invalid cell");
	      return false;
	} }
	  if(m[cell[0]][cell[1]] != "    ") {
	    System.out.println("\nRow " + cell[0] + " column " + cell[1] + " is filled");
	     return false;
	    }
	  return true;
	}
	//returns a valid cell input by user
	public static int[] getCell (String[][] m, String t) {
	  // Create Scanner
	  Scanner input = new Scanner (System.in);
	  int[] cell = new int[2];
	  // Prompt player to enter a token
	  do {
	    System.out.print("Enter a row(0, 1, or 2) for player " + 1 + ": ");
	    cell[0] = input.nextInt();
	    cell[1] = input.nextInt();
	  } while(!validCell(m, cell));
	  return cell;
	}
	//fills the matrix cell with the player's token
	public static void placeToken(String[][] m, int[] e, String t) {
	  m[e[0]][e[1]] = t;
	}
	//swaps the elements in an array
	public static void swap(String[] p) {
	  String temp = p[0];
	p[0] = p[1];
	p[1] = temp;
	}
	//returns true if all the cells on the grid have filled with tokens and neither player has achieved a win
	public static boolean draw(String[][]m) {
	  for(int i = 0 ; i < m.length; i++) {
	    for(int j = 0; j < m.length; j++) {
	      if(m[i][j] == "    ")
	        return false;
	    }
	}
	  return true;
	}
	// three tokens in a diagonal row
	public static boolean diagonalWin(String[][] m, String t) {
	  int count = 0;
	  for(int i = 0; i < m.length; i++) {
	    if(m[i][i] == t)
	      count++;
	    if(count == 3)
	      return true;
	}
	 
	count = 0;
	    for(int i = 0, j = m[i].length - 1; j >= 0; j--, i++) {
	      if(m[i][j] == t)
	        count++;
	      if(count == 3)
	        return true;
	}
	    return false;
	  }
	  // three tokens in a vertical row
	  public static boolean verticalWin(String[][] m, String t) {
	    for(int i = 0; i < m.length; i++) {
	      int count = 0;
	      for (int j= 0; j < m[i].length; j++) {
	        if(m[j][i] == t)
	          count++;
	      }
	      if(count == 3)
	        return true;
	    }
	    return false;
	  }
	  // three tokens in an horizontal row
	  public static boolean horizontalWin(String[][] m, String t) {
	    for(int i = 0; i < m.length; i++) {
	      int count = 0;
	      for(int j = 0; j < m[i].length; j++) {
	        if(m[i][j] == t)
	          count++;
	      }
	      if(count ==3)
	        return true;
	    }
	    return false;
	  }
	  // three tokens i a horizontal, vertical or diagonal --- WIN
	  public static boolean win(String[][] m, String t) {
	    return horizontalWin(m, t) || verticalWin(m, t) || diagonalWin(m,t);
	}
	  // determines the satus of the game - win, draw or continue
	  public static int gameStatus(String [][] m, String e) {
	    if(win(m, e))
	      return 0;
	    else if(draw(m))
	      return 1;
	    else
	      return 2;
	} 

}
