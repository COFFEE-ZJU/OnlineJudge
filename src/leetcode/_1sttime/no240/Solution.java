package leetcode._1sttime.no240;

public class Solution {
    private int[][] matrix;
    private int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        int r,c;
        if (matrix == null || (r=matrix.length) == 0 ||
                matrix[0] == null || (c=matrix[0].length) == 0)
            return false;
        this.matrix = matrix;
        this.target = target;

        return searchHori(0, r-1, 0, c-1);
    }

    private boolean searchVert(int rs, int re, int cs, int ce){
        int idxrs = searchVert(rs, cs, ce);
        int idxre = searchVert(re, cs, ce);
        if (idxrs == -1) return false;
        if (matrix[rs][idxrs] == target) return true;
        if (idxre != -1 && matrix[re][idxre] == target) return true;
        idxre++;
        if (idxre > idxrs) return false;
        return searchHori(rs, re, idxre, idxrs);
    }
    private int searchVert(int r, int cs, int ce){
        if (cs == ce) return matrix[r][cs] <= target ? ce : -1;
        if (cs + 1 == ce) return matrix[r][ce] <= target ? ce : (matrix[r][cs] <= target ? cs : -1);

        int mid = (cs + ce) / 2;
        if (matrix[r][mid] == target) return mid;
        if (matrix[r][mid] < target) return searchVert(r, mid, ce);
        else return searchVert(r, cs, mid);
    }

    private boolean searchHori(int rs, int re, int cs, int ce){
        int idxcs = searchHori(rs, re, cs);
        int idxce = searchHori(rs, re, ce);
        if (idxcs == -1) return false;
        if (matrix[idxcs][cs] == target) return true;
        if (idxce != -1 && matrix[idxce][ce] == target) return true;
        idxce++;
        if (idxce > idxcs) return false;
        return searchVert(idxce, idxcs, cs, ce);
    }

    // 找该列中的target位置，返回最大的小于等于target的index，-1表示没有这样的数。
    private int searchHori(int rs, int re, int c){
        if (rs == re) return matrix[rs][c] <= target ? rs : -1;
        if (rs + 1 == re) return matrix[re][c] <= target ? re : (matrix[rs][c] <= target ? rs : -1);

        int mid = (rs + re) / 2;
        if (matrix[mid][c] == target) return mid;
        if (matrix[mid][c] < target) return searchHori(mid, re, c);
        else return searchHori(rs, mid, c);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        int[][] m = new int[][]{
                new int[]{1,   4,  7, 11, 15},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(sol.searchMatrix(m, 2));
        System.out.println(sol.searchMatrix(m, 1));
        System.out.println(sol.searchMatrix(m, 5));
        System.out.println(sol.searchMatrix(m, 7));
        System.out.println(sol.searchMatrix(m, 0));
    }
}
