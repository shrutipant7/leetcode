class Solution {
  class Pair {
    int row;
    int col;
    int dist;

    public Pair(int row, int col, int dist) {
      this.row = row;
      this.col = col;
      this.dist = dist;
    }
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] !=0) return -1;
    int n = grid.length;
    Queue<Pair> q = new ArrayDeque<>();
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    q.add(new Pair(0, 0, 1));
    dist[0][0] = 1;

    while (!q.isEmpty()) {
      Pair top = q.poll();
      if (top.row == n-1 && top.col == n-1) return top.dist;
      List<Pair> neighbors = findNeighbors(top, n);
      for (Pair neighbor : neighbors) {
        if (grid[neighbor.row][neighbor.col] == 0
            && dist[neighbor.row][neighbor.col] > top.dist + 1) {
                  dist[neighbor.row][neighbor.col] = top.dist + 1;
          q.add(neighbor);
        }
      }
    }
    return -1;
  }

  private List<Pair> findNeighbors(Pair top, int n) {
    int row = top.row;
    int col = top.col;
    List<Pair> neighbors = new ArrayList<>();
    for (int i=-1; i<=1; i++) {
        for (int j=-1; j<=1; j++) {
            if (i == 0 && j == 0) continue;
            if (col+j >=0 && col+j < n && row+i >=0 && row+i < n) neighbors.add(new Pair(row+i, col + j, top.dist + 1));
        }
    }
    return neighbors;
  }
}

