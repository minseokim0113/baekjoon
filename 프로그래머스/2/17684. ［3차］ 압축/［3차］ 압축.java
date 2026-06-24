import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }

        List<Integer> answer = new ArrayList<>();

        int idx = 27;
        int i = 0;

        while (i < msg.length()) {

            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            answer.add(dict.get(w));

            if (j <= msg.length()) {
                dict.put(msg.substring(i, j), idx++);
            }

            i += w.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}