class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int e1start = Integer.parseInt(event1[0].substring(0,2) +event1[0].substring(3));
        int e1end = Integer.parseInt(event1[1].substring(0,2) +event1[1].substring(3));
        
        int e2start = Integer.parseInt(event2[0].substring(0,2) +event2[0].substring(3));
        int e2end = Integer.parseInt(event2[1].substring(0,2) +event2[1].substring(3));        
        
        if(e1end <e2start || e2end <e1start)
            return false;
        
        return true;
        
    }
}