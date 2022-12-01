class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->a[0] == b[0]? a[1]-b[1]:a[0]-b[0]);
        int max = 0;
        int prev = reservedSeats[0][0];
        boolean a=false,b=false,c=false, d= false;
        max+=Math.max((prev-1)*2,0);
        for(int[] rseat:reservedSeats){
            if(prev!=rseat[0]){
                max+=(rseat[0]-prev-1)*2;
                if(!a && !b && !c && !d){
                    max +=2;
                }else if((!b & !c)|| (!c & !d) || (!a && !b)){
                    max+=1;
                }
                a=false;
                b=false;
                c=false;
                d = false;
            }
            if(rseat[1] == 2 || rseat[1] ==3){
                a= true;
            }
            else if(rseat[1] == 9 || rseat[1] ==8 )
                d = true;
            else if( rseat[1] ==4 || rseat[1] == 5){
                b = true;
             }
            else if(rseat[1] ==6 |rseat[1] == 7){
                c = true;                   
            }
            prev=rseat[0];
        }
        if(!a && !b && !c && !d){
            max +=2;
        }else if((!b & !c)|| (!c & !d) || (!a && !b)){
            max+=1;
        }
        max+=(n-prev)*2;           
        return max;
    }
}