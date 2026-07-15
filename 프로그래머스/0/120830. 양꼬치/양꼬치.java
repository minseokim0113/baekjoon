class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        ans = n*12000 + (k-(n/10))*2000;
        return ans;
    }
}