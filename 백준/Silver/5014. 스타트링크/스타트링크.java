import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[F + 1];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, 0});
        visited[S] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1];
            
            if (now == G) {
                System.out.println(cnt);
                return;
            }
            
            int nu = now + U;
            int nd = now - D;
            
            if (nu <= F && !visited[nu]) {
                q.offer(new int[] {nu, cnt + 1});
                visited[nu] = true;
            }
            
            if (nd >= 1 && !visited[nd]) {
                q.offer(new int[] {nd, cnt + 1});
                visited[nd] = true;
            }
        }
        
        System.out.println("use the stairs");
    }
}