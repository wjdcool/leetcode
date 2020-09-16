package old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                if (sb != null && sb.length() > 0) {
                    result.add(sb.toString());
                }
                sb = new StringBuffer();
            } else {
                sb.append(charArr[i]);
                if (i == charArr.length - 1) {
                    result.add(sb.toString());
                }
            }

        }
        Collections.reverse(result);
        return String.join(" ",result);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
