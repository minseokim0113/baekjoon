import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        char[] ch = cipher.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < ch.length; i++) {
            if((i + 1) % code == 0) {
                sb.append(ch[i]);
            }
        }
        
        return sb.toString();
    }
}