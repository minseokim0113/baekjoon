class Solution {
    public int solution(int num) {
        
        int cnt = 0;
        
        while (num != 1) {
            if (cnt > 400) return -1;
            
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            cnt++;
        }
        
        return cnt;
    }
}