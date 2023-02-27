
// Definition for a QuadTree node.
// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

    
//     public Node() {
//         this.val = false;
//         this.isLeaf = false;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;
//         this.bottomRight = bottomRight;
//     }
// }Z


class Solution {
    
    
    boolean sameValue(int[][] grid,  int[] start, int[] end) {
        if(start[0] == end[0] && start[1] == end[1])
            return true;
        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++)
                if (grid[i][j] != grid[start[0]][start[1]])
                    return false;
        }
        return true;
    }

    public Node construct(int[][] grid) {
        return construct(grid, new int[]{0,0}, new int[]{grid.length-1, grid[0].length-1});


    }

    public Node construct(int[][] grid, int[] start, int[] end) {
        if(start[0]>end[0] || start[1]>end[1])
            return null;
        Node node = new Node();
        if(sameValue(grid, start, end)){
            node.isLeaf = true;
            if(grid[start[0]][start[1]] ==1 )
                node.val = true;
            return node;
        }
        int midRow = start[0] + (end[0]-start[0])/2;
        int midCol = start[1] + (end[1]-start[1])/2;

        node.topLeft = construct(grid, start, new int[]{midRow, midCol});
        node.topRight = construct(grid, new int[]{start[0] , midCol+1}, new int[]{midRow, end[1]});
        node.bottomLeft = construct(grid, new int[]{midRow+1,  start[1]}, new int[]{end[0], midCol});
        node.bottomRight = construct(grid, new int[]{midRow+1, midCol+1}, end);

        return node;

        
    }    
}