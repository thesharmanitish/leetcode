class Solution {
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        Arrays.sort(frequency);
        
        int deleteCount = 0;
        // Maximum frequency the current character can have
        int maxFreqAllowed = s.length();
        
        for(int i=25;i>=0;i--){
            if(frequency[i] ==0)
                break;
            if(frequency[i]>maxFreqAllowed){
                deleteCount +=frequency[i] - maxFreqAllowed;;
                frequency[i] = maxFreqAllowed;
            }
            maxFreqAllowed = Math.max(frequency[i]-1,0);
        }
        return deleteCount;
    }
}