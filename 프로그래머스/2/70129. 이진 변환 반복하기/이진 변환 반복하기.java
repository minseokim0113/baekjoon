import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb;
        String answer = s;
        int del = 0;
        int cnt = 0;
        
        while (!answer.equals("1")) {
            sb = new StringBuilder();
            
            for (char c : answer.toCharArray()) {
                if (c == '1') {
                    sb.append(Character.toString(c));
                } else {
                    del++;
                }
            }
            
            int len = sb.length();
            
            answer = Integer.toString(len, 2);
            
            cnt++;
        }
        
        return new int[] {cnt, del};
    }
}