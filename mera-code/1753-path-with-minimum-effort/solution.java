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

    public int minimumEffortPath(int[][] heights) {
           int n = heights.length;
    int m = heights[0].length;
    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
    int[][] dist = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    q.add(new Pair(0, 0, 0));
    dist[0][0] = 0;

    while (!q.isEmpty()) {
      Pair top = q.poll();
      List<Pair> neighbors = findNeighbors(top, n, m, heights);
      for (Pair neighbor : neighbors) {
        if (dist[neighbor.row][neighbor.col] > neighbor.dist) {
          dist[neighbor.row][neighbor.col] = neighbor.dist;
          q.add(neighbor);
        }
      }
    }
    return dist[n - 1][m - 1];
  }

  private List<Pair> findNeighbors(Pair top, int n, int m, int[][] heights) {
    int row = top.row;
    int col = top.col;
    List<Pair> neighbors = new ArrayList<>();
    if (col - 1 >= 0)
      neighbors.add(
          new Pair(
              row,
              col - 1,
              Math.max(
                  top.dist,
                  Math.abs(heights[top.row][top.col] - heights[row][col - 1]))));
    if (col + 1 < m)
      neighbors.add(
          new Pair(
              row,
              col + 1,
              Math.max(
                  top.dist,
                  Math.abs(heights[top.row][top.col] - heights[row][col + 1]))));
    if (row - 1 >= 0)
      neighbors.add(
          new Pair(
              row - 1,
              col,
              Math.max(
                  top.dist,
                  Math.abs(heights[top.row][top.col] - heights[row - 1][col]))));
    if (row + 1 < n)
      neighbors.add(
          new Pair(
              row + 1,
              col,
              Math.max(
                  top.dist,
                  Math.abs(heights[top.row][top.col] - heights[row + 1][col]))));
    return neighbors;
  }
}

