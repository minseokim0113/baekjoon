import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
        int[] arr = emergency.clone();
        
        Arrays.sort(arr);
        
        int[] answer = new int[emergency.length];
        
        for(int i = 0; i < emergency.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(emergency[i] == arr[j]) {
                    answer[i] = emergency.length - j;
                }
            }
        }
        
        return answer;
    }
}