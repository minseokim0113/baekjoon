import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> person = new HashMap<>();
        int cnt = 0;
        
        for (String r : record) {
            String[] text = r.split(" ");
            
            if (text[0].equals("Enter")) {
                person.put(text[1], text[2]);
                cnt++;
            } else if (text[0].equals("Change")) {
                person.put(text[1], text[2]);
            } else {
                cnt++;
            }
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        
        for (String r : record) {
            String[] text = r.split(" ");
            
            if (text[0].equals("Enter")) {
                answer[idx] = person.get(text[1]) + "님이 들어왔습니다.";
                idx++;
            } else if (text[0].equals("Leave")){
                answer[idx] = person.get(text[1]) + "님이 나갔습니다.";
                idx++;
            } else {
                continue;
            }
        }
        
        return answer;
        
    }
  
}
