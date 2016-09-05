package leetcode._1sttime.no304;

public class NumMatrix {
    private long[][] sums;
    private int r,c;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || (r=matrix.length) == 0 ||
                matrix[0] == null || (c=matrix[0].length) == 0)
            return;

        sums = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                sums[i][j] = sumAt(i-1, j) - sumAt(i-1, j-1) + sumAt(i, j-1) + matrix[i][j];
        }
    }

    private long sumAt(int i, int j){
        if (i < 0 || j < 0) return 0;
        else return sums[i][j];
    }

    private void checkRowRange(int i) {
        if (i < 0 || i >= r)
            throw new ArrayIndexOutOfBoundsException();
    }
    private void checkColRange(int i) {
        if (i < 0 || i >= c)
            throw new ArrayIndexOutOfBoundsException();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        checkRowRange(row1);
        checkRowRange(row2);
        checkColRange(col1);
        checkColRange(col2);
        if (row1 > row2 || col1 > col2)
            throw new ArrayIndexOutOfBoundsException();

        return (int) (sums[row2][col2] - sumAt(row1-1, col2) + sumAt(row1-1, col1-1) - sumAt(row2, col1-1));
    }

    public static void main(String[] args) {
    }
}
