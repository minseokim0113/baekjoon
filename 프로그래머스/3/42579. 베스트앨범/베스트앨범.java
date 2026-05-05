import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            list.add(i);
        }
        
        Collections.sort(list, (a, b) -> {
            if (!genres[a].equals(genres[b])) {
                return total.get(genres[b]) - total.get(genres[a]);
            }
            
            if (plays[b] != plays[a]) {
                return plays[b] - plays[a];
            }
            
            return a - b;
        });
        
        Map<String, Integer> count = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i : list) {
            if (count.getOrDefault(genres[i], 0) < 2) {
                answer.add(i);
                count.put(genres[i], count.getOrDefault(genres[i], 0) + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}