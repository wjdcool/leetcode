package 整数中1出现的次数;

/**
 * Created by wjd on 2020/4/23.
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class Solution {
    public int countDigitOne(int n) {

        return count(n);
    }

    //1234 = 千分位*234个+
    public int count(int num) {
        if (num <= 0) {
            return 0;
        }
        String str = String.valueOf(num);
        int pow = (int) Math.pow(10, str.length() - 1); //1000

        int high = Integer.parseInt(str.substring(0, 1)); //1

        int last = str.substring(1, str.length()) == null || str.substring(1, str.length()).equals("") ? 0 : Integer.parseInt(str.substring(1, str.length()));//234

        //1234 时  1 开头 234 -0+1个数+ count(234) + h*count(999)
        //2以上开头时，0-999 1000-1999 2000-N999 last  =count(999)+ count(last) + h*count(999) +pow pow相当于1000-1999，拉满的234

        if (high == 1) {
            return last + 1 + count(pow - 1) + count(last);
        } else {
            return pow + high * count(pow - 1) + count(last);
        }


    }
}
