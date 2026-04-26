import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            boolean shouldDelete = false;
            
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    shouldDelete = true;
                    break;
                }
            }
            
            if (!shouldDelete) {
                answer.add(arr[i]);
            }
        }
        
        int[] array = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            array[i] = answer.get(i);
        }
        
        return array;
    }
}