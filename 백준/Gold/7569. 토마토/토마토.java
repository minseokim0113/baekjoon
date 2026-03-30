import java.util.*;
import java.io.*;

public class Main {
    
    static int H, N, M;
    static int[][][] box;
    static Queue<Point> que = new LinkedList<>();
    
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    static class Point {
        int x, y, z;
        
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if(box[h][n][m] == 1) {
                        que.offer(new Point(m, n, h));
                    }
                }
            }
        }
        
        bfs();
        
        int answer = 0;
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    
                    answer = Math.max(answer, box[h][n][m]);
                }
            }
        }
        
        System.out.println(answer - 1);
    }
    
    static void bfs() {
        while(!que.isEmpty()) {
            Point cur = que.poll();
            
            for(int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                
                if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
                    continue;
                }
                
                if(box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[cur.z][cur.y][cur.x] + 1;
                    que.offer(new Point(nx, ny, nz));
                }
            }
        }
    }
}