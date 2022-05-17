class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start = 0, cur=0, max = 0;
        char[] nums = s.toCharArray();
        boolean[] letters = new boolean[256];
        for(int i=0;i<s.length();i++){
            cur++;
            if(letters[nums[i]]){
                for(int j=start;j<i;j++){
                    if(nums[j]== nums[i]){
                        start = j+1;
                        
                        break;
                        
                    }
                }
                cur = i-start+1;
            }else
                letters[nums[i]] = true;
            max = Math.max(cur, max);
            
        }
        return max;
    }
}