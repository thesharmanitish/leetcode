class Solution {
    
    class Pair{
        int count;
        int row;
        public Pair(){
        }
        public Pair(int count, int row){
         this.count = count;   
         this.row = row;
        }
        
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1,o2)->{
            return o1.count==o2.count?o1.row-o2.row:o1.count-o2.count;
        });
        
        for(int i=0;i<mat.length;i++){
            int count =0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1)
                    count++;
            }
            pq.offer(new Pair(count,i));
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll().row;
        }
        return res;
    }
}