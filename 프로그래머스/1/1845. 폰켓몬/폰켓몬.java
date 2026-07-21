import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> num = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }
        
        int mu = nums.length / 2;
        
        if (num.size() >= mu) {
            return mu;
        } else {
            return num.size();
        }
    }
}