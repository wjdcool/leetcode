package 剑指offer.矩阵中的路径12;

/**
 * @Author wjd
 * @Date 2020/10/27 15:18
 * @Description
 **/
public class SolutionDfs {
    public static void main(String[] args) {
        char[][] a = new char[1][1];
        a[0][0] = 'a';
//        a[0][1] = 'a';
        System.out.println(exist(a, "ab"));
    }

    public static boolean exist(char[][] board, String word) {
        char[] s = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == s[0]) {
                    if (dfs(i, j, 0, board, s)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean dfs(int i, int j, int n, char[][] board, char[] s) {
        if (n == s.length ) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        char tmp = board[i][j];
        boolean t = false;
        if (board[i][j] == s[n]) {
            board[i][j] = '1';
            t = dfs(i - 1, j, n + 1, board, s) || dfs(i + 1, j, n + 1, board, s) || dfs(i, j - 1, n + 1, board, s) || dfs(i, j + 1, n + 1, board, s);
        }
        board[i][j] = tmp;
        return t;
    }
}