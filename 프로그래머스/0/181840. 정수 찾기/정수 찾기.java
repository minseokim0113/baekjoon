import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < num_list.length; i++) {
            list.add(num_list[i]);
        }
        if (list.contains(n)) {
            return 1;
        } else {
            return 0;
        }
    }
}