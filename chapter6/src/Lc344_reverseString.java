import java.util.Scanner;

public class Lc344_reverseString {

    public static void reverseString(char[] s) {
        //双指针
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }

    }



}
