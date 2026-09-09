import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> num = new HashSet<>();
        
        for(int j = 0; j < nums.length; j++) {
            num.add(nums[j]);
        }
        
        int mu = nums.length / 2;
        
        if (num.size() >= mu) {
            return mu;
        } else {
            return num.size();
        }
    }
}