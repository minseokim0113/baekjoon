import java.util.*;

class Solution {
    
    static boolean found = false;
    static int min = Integer.MAX_VALUE;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph= new List[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0; i < sources.length; i++) {
            
            visited = new boolean[n + 1];
            visited[sources[i]] = true;
            min = Integer.MAX_VALUE;
            found = false;
            
            // dfs(sources[i], destination, 0);
            if (sources[i] == destination) {
                answer[i] = 0;
                continue;
            }
            bfs(sources[i], destination);
            if (!found) {
                min = -1;
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
    
    static void dfs(int s, int destination, int cnt) {
        if (s == destination) {
            found = true;
            min = Math.min(min, cnt);
            return;
        }
        
        for (int next : graph[s]) {
            if (!visited[next]) {
                visited[next] = true;
                // cnt++;
                dfs(next, destination, cnt + 1);
                // cnt--;
                visited[next] = false;
            }
        }
        
        return;
    }
    
    static void bfs(int s, int destination) {
        
        int[] dist = new int[graph.length];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        dist[s] = 0;
        
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                
                if (next == destination) {
                    found = true;
                    min = Math.min(dist[cur] + 1, min);
                }
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
            
        }
        
        return;
    }
}