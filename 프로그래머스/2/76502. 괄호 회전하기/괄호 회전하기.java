import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        Queue<Character> que = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            que.offer(c);
        }
        
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isTrue(que)) {
                cnt++;
            }
            
            if (!que.isEmpty()) {
                char c = que.poll();
                que.offer(c);   
            }
        }
        
        return cnt;
    }
    
    Boolean isTrue(Queue<Character> q) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> que = new LinkedList<>(q);
        
        while(!que.isEmpty()) {
            char c = que.poll();
            
            if (!stack.isEmpty()) {
                if(c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == ')' && stack.peek() =='(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }   
            } else {
                stack.push(c);
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}