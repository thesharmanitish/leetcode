class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if(s.equals(target))
            return true;
        return target.indexOf("1") !=-1 && s.indexOf("1")!=-1 ;
    }
}