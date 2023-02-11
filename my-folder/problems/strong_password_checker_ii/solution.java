class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean isLowerCase = false, isUpperCase = false, isDigit = false, isSplChar = false;
        char prev = ' ';
        if(password.length()<8)
            return false;
        for(char c:password.toCharArray()){
            if(Character.isLowerCase(c))
                isLowerCase = true;
            else if(Character.isUpperCase(c))
                isUpperCase = true;
            else if(Character.isDigit(c))
                isDigit = true;
            else
                isSplChar = true;
                
            if(prev == c)
                return false;
            prev = c;
        }
        return isLowerCase && isUpperCase && isDigit && isSplChar;
    }
}