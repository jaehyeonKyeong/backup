package day0403;

public class FillArrayRun {

	public static void main(String[] args) {
		int[][] board = null;
		board=new int[5][5];
		FillArray fa = new FillArray(board);
		fa.runFillArray();
		fa.printBoard();
	}
}