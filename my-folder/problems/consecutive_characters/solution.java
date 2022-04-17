class Solution {
    public int maxPower(String s) {
        int max = Integer.MIN_VALUE, count = 1;
       for(int i=1;i<s.length();i++){
           if(s.charAt(i) ==s.charAt(i-1)  )
               count++;
           else
               count =1;
           if(max<count)
               max = count;
       }
         return max>count?max:count;  
    }
}