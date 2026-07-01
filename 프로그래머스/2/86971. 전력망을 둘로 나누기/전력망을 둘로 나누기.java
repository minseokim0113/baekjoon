import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            
            List<Integer>[] graph = new ArrayList[n + 1];
            
            for(int k = 1; k < n + 1; k++) {
                graph[k] = new ArrayList<>();
            }
            
            for (int j = 0; j < wires.length; j++) {
                if(j == i) {
                    continue;
                }
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            boolean[] visited = new boolean[n+1];
            
            dfs(wires[i][0], visited, graph);
            
            int cnt = 0;
            
            for (int b = 1; b < visited.length; b++) {
                if(visited[b]) {
                    cnt++;
                }
            }
            
            int diff = Math.abs(cnt - (n - cnt));
            
            if (diff <= min) {
                min = diff;
            }
        }
        
        return min;
    }
    
    static void dfs(int start, boolean[] visited, List<Integer>[] graph) {
        visited[start] = true;

        for(int next : graph[start]) {
            if (!visited[next]) {
                dfs(next, visited, graph);
            }
        }
    }
}