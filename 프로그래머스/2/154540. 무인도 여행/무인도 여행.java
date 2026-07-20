import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new int[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            char[] c = maps[i].toCharArray();
            
            for (int j = 0; j < c.length; j++) {
                if (c[j] == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = c[j] - '0';
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    int cnt = bfs(i, j);
                    if (cnt != 0) {
                        list.add(cnt);
                    }
                }
            }
        }
        
        if(list.size() == 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int size = map[x][y];
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= map.length ||  ny >= map[0].length) {
                    continue;
                }
                
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    que.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    size += map[nx][ny];
                }
            }
        }
        
        return size;
    }
}