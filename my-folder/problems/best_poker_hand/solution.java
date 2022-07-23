class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] r = new int[14];
        int[] s = new int[5];
        int maxr = 0, maxs = 0;
        for(int i:ranks){
            r[i] +=1;
            maxr = Math.max(maxr, r[i]);
        }
        for(char i:suits){
            s[i-'a'] +=1;
            maxs = Math.max(maxs, s[i-'a']);
        }
        
        if(maxs ==5)
            return "Flush";
        if(maxr >=3)
            return "Three of a Kind";
        if(maxr>=2)
            return "Pair";
        return "High Card";
            
//             "Flush": Five cards of the same suit.
// "Three of a Kind": Three cards of the same rank.
// "Pair": Two cards of the same rank.
// "High Card"
        
        
    }
}