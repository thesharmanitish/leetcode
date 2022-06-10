class Solution {
    public int lengthOfLongestSubstring(String s) {

        boolean[] arr = new boolean[256];
        char[] c = s.toCharArray();
        
        if(c.length<=1)
            return c.length;
        
        int start=0, end = 1;
        int max = 1;
        arr[c[start]] = true;
        while(end< c.length ){
            if(arr[c[end]]){
                while(c[start]!=c[end]){
                    arr[c[start]] = false;
                    start++;
                }
                start+=1;
                if(start>end)
                    end = start +1;
            }else {
                arr[c[end]]  = true;
                
            }
            
            max=  Math.max(max, Math.min(c.length,end)- start+1);
            end++;
        }
        return max;
    }
}