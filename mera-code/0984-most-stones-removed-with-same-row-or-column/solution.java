class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node) {
        if (parent.get(node) == node)
            return node;
        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }

    void unionBySize(int u, int v) {
        int uPar = findUPar(u), vPar = findUPar(v);
        if (uPar == vPar)
            return;
        if (size.get(uPar) <= size.get(vPar)) {
            parent.set(uPar, vPar);
            size.set(vPar, size.get(uPar) + size.get(vPar));
        } else {
            parent.set(vPar, uPar);
            size.set(uPar, size.get(uPar) + size.get(vPar));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int connComp = 0;
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Set<Integer> candUltPar = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            int xCord = stones[i][0];
            int yCord = stones[i][1] + maxRow + 1;
            ds.unionBySize(xCord, yCord);
            candUltPar.add(xCord);
            candUltPar.add(yCord);
        }
        for (int up : candUltPar) {
            if (ds.findUPar(up) == up)
                connComp++;
        }
        return stones.length - connComp;
    }
}
