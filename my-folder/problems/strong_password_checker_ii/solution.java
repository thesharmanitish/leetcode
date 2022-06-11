class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean isCapital = false, isSmaller = false, isNumber = false, isSymbol = false , isConsecutive=false;
        if(password.length()<8)
            return false;
        Character prev = null;
        for(char c:password.toCharArray()){
            if(prev !=null && prev == c)
                return false;
            
            if(Character.isDigit(c))
                isNumber = true;
            else if(c >='a' && c<= 'z')
                isSmaller = true;
            else if(c >='A' && c<= 'Z')
                isCapital = true;
            else isSymbol= true;
            
            prev = c;
                
        }
        return isNumber && isSmaller && isCapital && isSymbol;
        
    }
}