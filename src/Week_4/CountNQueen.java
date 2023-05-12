public class CountNQueen{
    static int count=0;
    public static void main(String[] args) {
        int n = 5;
        char board[][]= new char[n][n];

        // initlialzie
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }

        nQueen(board, 0);
        System.out.println(count);
    }

    public static boolean isSafe(char board[][], int row,int col){
        // check row
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q')return false;
        }

        // check up left 
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }

        // check right left
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q')return false;
        }

        return true;
    }

    public static void nQueen(char board[][],int row){
        // base call
        if(row==board.length){
            count++;
            return;
        }
        

        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row , j)){
                board[row][j]='Q';
                nQueen(board, row+1);
                board[row][j] = 'X'; // Backtraking step
            }
        }
    }
}