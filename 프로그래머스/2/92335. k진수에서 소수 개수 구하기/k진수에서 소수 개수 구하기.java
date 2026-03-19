import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);
        
        String[] nums = num.split("0+");
        int answer = 0;
        
        for(String b : nums) {
            long a = Long.parseLong(b);
            if(isPrime(a)) {
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean isPrime(long a) {
        if(a < 2) return false;
        
        for(long i = 2; i*i <= a; i++) {
            if(a % i == 0) return false;
        }
        
        return true;
    }
}