import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (char ch : number.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() < ch) {

                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}