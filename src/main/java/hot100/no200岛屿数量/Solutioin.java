package hot100.no200岛屿数量;

/**
 * @Author wjd
 * @Date 2020/12/10 14:44
 * @Description
 **/
public class Solutioin {
    public static void main(String[] args) {
        char[][] arr = {};
        System.out.println(numIslands(arr));
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] check = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && check[i][j] == false) {
                    dfs(check, grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    static void dfs(boolean[][] check, char[][] gird, int i, int j) {
        if (!(i >= 0 && i < gird.length && j >= 0 && j < gird[0].length)) {
            return;
        }
        if (gird[i][j] == '0') {
            return;
        }
        if (check[i][j] == true) {
            return;
        }
        check[i][j] = true;
        if (i > 0 || i < gird.length - 1) {
            dfs(check, gird, i - 1, j);
            dfs(check, gird, i + 1, j);
        }
        if (j > 0 || j < gird[0].length - 1) {
            dfs(check, gird, i, j - 1);
            dfs(check, gird, i, j + 1);
        }
    }

}
