import java.util.*;

class Solution {
    public String solution(String s) {
        String[] chArr = s.split(" ", -1);
        StringJoiner sj = new StringJoiner(" ");
        for(int i=0; i<chArr.length; i++) {
            StringBuilder str = new StringBuilder();
            for(int j=0; j<chArr[i].length(); j++) {
                String temp = String.valueOf(chArr[i].charAt(j));
                if(j%2==0) {
                    str.append(temp.toUpperCase());
                } else {
                    str.append(temp.toLowerCase());
                }
            }
            sj.add(str);
            
        }
        
        return sj.toString();
    }
}