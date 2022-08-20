class Solution {
    public int minimumRecolors(String blocks, int k) {  
        char[] arr = blocks.toCharArray();
        int nwhite = 0;
        for(int i=0;i<k;i++){
            nwhite += arr[i] == 'W'?1:0;
        }    
        int min = nwhite, start=0;
        
        
        
        for(int i=k;i<arr.length;i++){
           nwhite -= arr[start++]=='W'?1:0;
           nwhite += arr[i] == 'W'?1:0;
           min = Math.min(min, nwhite) ;
        }
        return min;
    }
}