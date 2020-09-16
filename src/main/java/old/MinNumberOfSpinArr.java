package old;

public class MinNumberOfSpinArr {
    public int minArray(int[] numbers) {
        int end = numbers.length-1;
        int start = 0;
        if (end == 0) {
            return numbers[0];
        }
        while (true) {
            if(start == end){
                return numbers[start];
            }
            int mid = (end + start)/2;
            if (numbers[mid] > numbers[end]) {
                start = mid+1;
                continue;
            }
            if(numbers[mid]<numbers[end]){
                end = mid;
                continue;
            }
            if(numbers[mid] == numbers[end]){
                end--;
                continue;
            }
        }
    }
}
