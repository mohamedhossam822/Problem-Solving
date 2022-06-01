class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] shortestPath = new int[m][n];
        int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 } };
        shortestPath[0][0] = 1;
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<Pair<Integer, int[]>>(4, (a, b) -> a.getKey() - b.getKey());
        pq.add(new Pair<>(1, new int[] { 0, 0 }));
        int[] p;
        int i, j;
        while (!pq.isEmpty()) {
            Pair<Integer, int[]> pair = pq.poll();
            p = pair.getValue();
            i = p[0];
            j = p[1];
            if (i == m - 1 && j == n - 1) break;
            visited[i][j] = true;
            for (int r[] : dir) {
                int dx = r[0] + i;
                int dy = r[1] + j;
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 0) {
                    if(!visited[dx][dy]) {
                        shortestPath[dx][dy]=1+shortestPath[i][j];
                        pq.add(new Pair <> (shortestPath[dx][dy],new int[]{dx,dy}));
                    }
                    else if(1+shortestPath[i][j]<shortestPath[dx][dy]) shortestPath[dx][dy]=1+shortestPath[i][j];
                    visited[dx][dy]=true;
                }
            }
            
        }
        if (shortestPath[m - 1][n - 1] == 0) return -1;
        return shortestPath[m - 1][n - 1];
    }
}
