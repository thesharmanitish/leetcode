class Solution {
    public int minMovesToMakePalindrome(String s) {
        int count =0;
        while(s.length() > 0){
            int ind = s.indexOf(s.charAt(s.length()-1));
            if(ind == s.length()-1)
                count +=s.length()/2;
            else{
                count += ind;
                s = s.substring(0,ind)+s.substring(ind+1);
            }
            s = s.substring(0,s.length()-1);
        }
        return  count;
    }
}