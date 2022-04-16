class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(cost1<cost2)
            waysToBuyPensPencils(total, cost2, cost1) ;
        long count =0;
        
        int pens = total/cost1;
        while(pens>=0){
            
            count+=(total-pens*cost1) /cost2+1;
            pens--;
        }
        return count;
        
    }
}