import java.util.*;

class Solution {
    public String solution(String s) {
        char[] strArr = s.toCharArray();
        char[] arr = new char[26];
        for(int i=0; i<strArr.length; i++) {
            arr[strArr[i]-'a'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                sb.append((char)(i+'a'));
            }
        }
        
        return sb.toString();
    }
}