import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        int cb = k;
        int cnt = 0;
        
        dfs(dungeons, cb, cnt, visited);
        
        return answer;
        
    }
    
    public void dfs(int[][] dungeons, int cb, int cnt, boolean[] visited) {
        
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && cb >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, cb - dungeons[i][1], cnt + 1, visited);
                visited[i] = false;
            }
        }
        
    }
}