class Solution {
    public int maxDistance(int[] colors) {
        int max = -1;
        for(int start=0;start<colors.length;start++){
            for(int i=start+1;i<colors.length;i++){
                if(colors[i]!=colors[start])
                    max= Math.max(max,i-start);
            }   
        }
        return max;        
    }
}