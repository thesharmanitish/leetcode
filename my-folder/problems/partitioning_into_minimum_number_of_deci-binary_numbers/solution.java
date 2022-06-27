class Solution {
    public int minPartitions(String n) {
        boolean flag = false;
        int max = 0;
        for(char c:n.toCharArray()){
            // if(c-'0'  >1)
            //     flag =true;
            max = Math.max(max, c-'0');
        }
        // if(!flag)
        //     return 0;
        
        return max;
    }
}