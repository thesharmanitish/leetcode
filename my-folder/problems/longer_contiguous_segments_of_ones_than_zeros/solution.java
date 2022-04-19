class Solution {
    public boolean checkZeroOnes(String s) {
        int[] count =new int[2];
        int prev =-1, max1 =0, max2=0;
        char[] ch = s.toCharArray();
        for(char c:ch){
            if(prev == c)
                count[prev-'0']++;
            else
                count[c-'0'] =1;
            prev = c;
           if(max1<count[0])
               max1 = count[0];
           else if(max2<count[1])
                max2 = count[1];
        }
        return max1<max2?true:false;
    }
}