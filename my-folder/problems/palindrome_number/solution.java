class Solution {
    public boolean isPalindrome(int x) {
        String z = String.valueOf(x);
        for(int i=0;i<z.length();i++)
            if(z.charAt(i)!=z.charAt(z.length()-1-i))
                return false;
        return true;
    }
}