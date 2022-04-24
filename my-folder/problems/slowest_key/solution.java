class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0], ind = 0;
        char[] charr = keysPressed.toCharArray();
        for(int i=1;i<releaseTimes.length;i++){
            int t = releaseTimes[i]-releaseTimes[i-1];
            if(max < t){
                max = t;
                ind = i;
            }else if(max ==t){
                if(charr[ind] < charr[i]){
                    max = t;
                    ind = i;                    
                }
            }
        }
          return charr[ind];
    }
  
}