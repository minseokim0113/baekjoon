import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] board;
    static int[][] copy;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;
    static int n;
    static int m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(answer);
    }
    
    static void dfs(int depth) {
        if(depth == 3) {
            spreadVirus();
            return;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static void spreadVirus() {
        // 깊은 복사
        copy = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // 바이러스 위치 넣기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // BFS
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        // 안전 영역 계산
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}