import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        // 10^7
        for(int i = 0; i < phone_book.length; i++) { // 10^6 
            for(int j = 0; j < phone_book[i].length(); j++) { // 10^1
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }
        return true;
    }
}