import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        int cnt = 0;
        
        for(int i : scoville) {
            pque.offer(i);    
        }
        
        while(pque.size() >= 2 && pque.peek() < K) {
            int m1 = pque.poll();
            int m2 = pque.poll();
            
            pque.offer(m1 + 2 * m2);
            cnt++;
        }
        
        if(pque.peek() < K) return -1;
        
        return cnt;
    }
}