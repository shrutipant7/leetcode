class Solution {
  public int orangesRotting(int[][] grid) {
    Queue<int[]> q = new ArrayDeque<>();
    int m = grid.length;
    int n = grid[0].length;
    int time = 0;
    int total = 0;
    int rotten = 0;
    boolean[][] vis = new boolean[m][n];

    // Pre-fill the queue and visited array with rotten oranges
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          q.add(new int[] {i, j});
          vis[i][j] = true;
          rotten++;
          total++;
        } else if (grid[i][j] == 1) {
          total++;
        }
      }
    }

    while (!q.isEmpty()) {
      int size = q.size();
      while (size > 0) {
        int[] top = q.poll();
        int[][] neighbors = new int[4][2];
        neighbors[0] = new int[] {top[0], top[1] - 1};
        neighbors[1] = new int[] {top[0], top[1] + 1};
        neighbors[2] = new int[] {top[0] - 1, top[1]};
        neighbors[3] = new int[] {top[0] + 1, top[1]};
        for (int[] neighbor : neighbors) {
          if (neighbor[0] >= 0
              && neighbor[0] < m
              && neighbor[1] >= 0
              && neighbor[1] < n
              && !vis[neighbor[0]][neighbor[1]]
              && grid[neighbor[0]][neighbor[1]] == 1) {
            vis[neighbor[0]][neighbor[1]] = true;
            rotten++;
            q.add(neighbor);
          }
        }
        size--;
      }
      time++;
    }
    return rotten == total ? total == 0 ? 0 : time - 1 : -1;
  }
}

