class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2)
            return true;
        if(Character.isLowerCase(word.charAt(0)))
            return detectCapitalUse(word.toCharArray(), false);
        else if(Character.isLowerCase(word.charAt(1)))
            return detectCapitalUse(word.toCharArray(), false);
        else
            return detectCapitalUse(word.toCharArray(), true);


    }
    public boolean detectCapitalUse(char[] word, boolean isCapital) {
        for(int i=1;i<word.length;i++){
            if(isCapital && Character.isLowerCase(word[i]))     
                return false;
            else if(!isCapital && Character.isUpperCase(word[i]))     
                return false;
        }
        return true;
    }
}