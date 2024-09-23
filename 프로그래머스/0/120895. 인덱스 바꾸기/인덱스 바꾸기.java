import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        
        char[] chArr = my_string.toCharArray();
        
        chArr[num1] = my_string.charAt(num2);
        chArr[num2] = my_string.charAt(num1);
        
        return String.valueOf(chArr);
    }
}