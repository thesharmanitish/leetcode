class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sarr = new int[254];
        int[] tarr = new int[254];
        int prev = 0;
        for(int i=0;i<s.length();i++){
            // if(s.charAt(i)-'a' !=prev){
            //     sarr[prev] =0;
            //     tarr[prev] =0;
            // }
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)])
                return false;            
            sarr[s.charAt(i)] =i+1;
            tarr[t.charAt(i)] =i+1;

        }
        return true;
    }
}