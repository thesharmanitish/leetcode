class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int ones = 0, zeros=0;
        for(char c:s.toCharArray()){
            if(c=='0')
                zeros++;
        }
        ones = 0;

        int min = zeros;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')
                zeros--;
            if(s.charAt(i)=='1')
                ones++;
            
            min = Math.min(ones+zeros, min);
        }

        return min;

    }
}