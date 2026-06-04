import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        List<Integer>[] winGraph = new List[n + 1];
        List<Integer>[] loseGraph = new List[n + 1];
        
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        
        for (int[] r : results) {
            int winner = r[0];
            int loser = r[1];
            
            winGraph[winner].add(loser);
            loseGraph[loser].add(winner);
        }
        
        int answer = 0;
        
        for (int i = 1; i < n + 1; i++) {
            
            int winCnt = bfs(i, winGraph);
            int loseCnt = bfs(i, loseGraph);
            
            if (winCnt + loseCnt == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static int bfs(int start, List<Integer>[] graph) {
        
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        int cnt = 0;
         
        while(!q.isEmpty()) {
            int player = q.poll();
            
            for (int a : graph[player]) {
                if (!visited[a]) {
                    cnt++;
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
        
        return cnt;
    }
}

/**
한명 기중 -> 진 횟수 + 이긴 횟수 = n - 1 순위 확정
**/