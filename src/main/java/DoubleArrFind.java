public class DoubleArrFind {
    public static boolean Find(int target, int[][] array) {
        int length = array.length;
        if (length < 1) {
            return false;
        }
        int width = array[0].length;
        if (width < 1) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (true) {
            if(i>length-1 || j<0){
                return false;
            }
            if(array[i][j] == target){
                return true;
            }
            if(array[i][j] > target){
                j--;
                continue;
            }
            if(array[i][j] < target){
                i++;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr ={{5}};
        System.out.println(Find(2,arr));
    }
}
