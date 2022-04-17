class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        char[] ch = answerKey.toCharArray();
        int max = 0, count = 0, count1 = 0;
        for(int i=0, j=-1, l=-1;i<ch.length;i++){
            if(ch[i] == 'F')
                count++;
            
            while(count>k){
                j++;
                if(ch[j]=='F')
                    count--;
            }
            
            if(ch[i] == 'T')
                count1++;
                        
            while(count1>k){
                l++;
                if(ch[l]=='T')
                    count1--;
            }            
            int len = i-j;
            int len1 = i-l;
            if(max<len)
                max = len;
            if(max<len1)
                max = len1;
        }
        return max;
    }
}