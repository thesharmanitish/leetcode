class Solution {
    
    /**
    
    The box is "Bulky" if:
        Any of the dimensions of the box is greater or equal to 104.
        Or, the volume of the box is greater or equal to 109.
    If the mass of the box is greater or equal to 100, it is "Heavy".
    If the box is both "Bulky" and "Heavy", then its category is "Both".
    If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
    If the box is "Bulky" but not "Heavy", then its category is "Bulky".
    If the box is "Heavy" but not "Bulky", then its category is "Heavy".


*/
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = false, isBulky =false;
        
        if(length >=10000 || width >=10000 || height >= 10000 || length* width >=1_000_000_000/height)
            isBulky = true;
        if(mass>=100)
            isHeavy = true;
        
        if(isHeavy && isBulky)
            return "Both";
        else if(isHeavy)
            return "Heavy";
        else if(isBulky)
            return "Bulky";
        else return "Neither";
    }
}