import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        
        int s = 1;
        int e = distance;
        
        while(s <= e) {
            int mid = (s + e) / 2;
            int prev = 0;
            int cnt = 0;
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            
            if(distance - prev < mid) {
                cnt++;
            }
            
            if(cnt <= n) {
                answer = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return answer;
    }
}