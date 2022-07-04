class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left  = new int[ratings.length];
        int[] right  = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);        
        left[0] = 1;
        right[ratings.length-1] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] >ratings[i-1]) 
               left[i] = left[i-1]+1;
               
            if(ratings[n-1-i] >ratings[n-i] )
               right[n-1-i] = right[n-i]+1;           
               
        }
        int count = 0;
        for(int i=0;i<ratings.length;i++){
            count+=Math.max(left[i], right[i]);
        }
               
        return count;
    }
}
               
               // 1 2 2
               // 1 2 