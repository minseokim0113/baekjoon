import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int day = stack.pop();
                answer[day] = i - day;
            }
            
            stack.push(i);
        }
        
        if (stack.size() >= 2) {
            int last = stack.pop();
            while(!stack.isEmpty()) {
                int cur = stack.pop();
                answer[cur] = last - cur;
            }
        }
        
        
        return answer;
    }
}