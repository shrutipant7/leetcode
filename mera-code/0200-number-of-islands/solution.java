class Solution {
    class Node{
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    island++;
                    bfs(grid, new Node(i, j));
                }
            }
        }
        return island;
    }
    
    // ----------  DFS  -----------
    // static void dfs(char[][] grid, int i, int j) {
    //     if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0') return;
    //     grid[i][j] = '0';
    //     dfs(grid, i+1, j);
    //     dfs(grid, i-1, j);
    //     dfs(grid, i, j+1);
    //     dfs(grid, i, j-1);
    // }
    
    // ----------- BFS -------------
     public void bfs(char[][] grid, Node first) {
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(first);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.row-1 >= 0 && grid[cur.row-1][cur.col] == '1'){
                q.add(new Node(cur.row-1, cur.col));
                grid[cur.row-1][cur.col] = '0';
            } 
            if(cur.row+1 < grid.length && grid[cur.row+1][cur.col] == '1'){                
                q.add(new Node(cur.row+1, cur.col));
                grid[cur.row+1][cur.col] = '0';
            } 
            if(cur.col-1 >= 0 && grid[cur.row][cur.col-1] == '1'){                
                q.add(new Node(cur.row, cur.col-1));
                grid[cur.row][cur.col-1] = '0';
            }
            if(cur.col+1 < grid[0].length && grid[cur.row][cur.col+1] == '1'){                
                q.add(new Node(cur.row, cur.col+1));
                grid[cur.row][cur.col+1] = '0';
            }
        }
    }
}
