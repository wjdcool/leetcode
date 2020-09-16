package old.不同路径;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * 输入: m = 3, n = 2
 * 输出: 3
 */
public class Test {

    public static int uniquePaths(int m, int n) {
        if(m == 0 || n==0){
            return 1;
        }
        int total = m+n-2;
        int part = 1;
        if(m <=n){
            part = m-1;
        }else{
            part = n-1;
        }

        Long multiTotal = 1L;
        Long partTotal = 1L;
        for(int i = total - part+1;i<=total;i++){
            multiTotal = multiTotal* i;
        }
        for(int i = 1;i<=part;i++){
            partTotal = partTotal * i;
        }
        Long result = multiTotal/partTotal;
        return Integer.parseInt(result.toString());

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(50,66));
    }
}
