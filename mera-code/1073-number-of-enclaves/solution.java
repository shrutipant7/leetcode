class Solution {
  class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int numEnclaves(int[][] grid) {
    int count = 0;
    Queue<Pair> q = new ArrayDeque<>();
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] vis = new boolean[m][n];

    // Pre-fill the queue and visited array with boundary cells who are land (1)
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
          q.add(new Pair(i, j));
          vis[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      Pair top = q.poll();
      List<Pair> neighbors = new ArrayList<>();
      neighbors.add(new Pair(top.x, top.y - 1));
      neighbors.add(new Pair(top.x, top.y + 1));
      neighbors.add(new Pair(top.x - 1, top.y));
      neighbors.add(new Pair(top.x + 1, top.y));
      for (Pair neighbor : neighbors) {
        if (neighbor.x >= 0
            && neighbor.x < m
            && neighbor.y >= 0
            && neighbor.y < n
            && !vis[neighbor.x][neighbor.y]
            && grid[neighbor.x][neighbor.y] == 1) {
          vis[neighbor.x][neighbor.y] = true;
          q.add(neighbor);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !vis[i][j]) {
          count++;
        }
      }
    }

    return count;
  }
}

