import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        List<String> usedWords = new ArrayList<>();
        usedWords.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            String word = words[i];
            
            if (usedWords.contains(word)) { // 사용한 단어 여부 확인. 
                return new int[]{i%n+1, i/n+1};
            }
            
            String lastWord = usedWords.get(i-1);
            if (lastWord.charAt(lastWord.length()-1) != word.charAt(0)) { // 마지막으로 말한 단어의 마지막 문자와 지금 말한 단어의 첫글자 매칭 여부 확인.
                return new int[]{i%n+1, i/n+1};
            }
            
            usedWords.add(word);
        }

        return answer;
    }
}