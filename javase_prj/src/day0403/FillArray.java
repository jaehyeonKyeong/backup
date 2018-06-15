package day0403;

public class FillArray {
	
	public int[][] board=null;
	//생성자
	public FillArray(int[][] board) {
		this.board=board;
	}
	//배열에 0,1 채우는 method
	public void runFillArray() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(i%2==1||(i+j)%2==1) {
					board[i][j]=1;
				} else {
					board[i][j]=0;
				}
			}
		}
	}
	//배열 출력 method
	public void printBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.printf("%-4d",board[i][j]);
			}
			System.out.println();
		}
	}
}
