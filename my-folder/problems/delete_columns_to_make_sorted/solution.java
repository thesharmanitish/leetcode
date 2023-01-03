class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0, len = strs[0].length();
        
        for(int j=0;j<len;j++){
            char prev = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){
                char cur = strs[i].charAt(j);
                if(cur<prev){
                    count++;
                    break;
                }
                prev = cur;
            }
        }
        return count;
    }
}