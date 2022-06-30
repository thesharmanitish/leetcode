class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> {return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];});
        int[] tails = new int[envelopes.length];
        
             // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) 
            secondDim[i] = envelopes[i][1];
        
        int size = 0;
        for(int n:secondDim){
            int start=0, end =size;
            while(start<end){
                int mid = (start+end) >>1;
                if(n>tails[mid])
                    start = mid+1;
                else
                    end = mid;
            }
            if(start ==size)
                size++;
            tails[start]  = n;
                
            
        }
        return size;
        
    }
}