class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        char prev = ' ';
        int n =sb.length() , count = 0;
        for(int i=0;i<sb.length();i++){
            if(prev == sb.charAt(i)){
                count += 1;
                if(count == k){
                    prev = ' ';
                    while(count-->0)
                        sb.deleteCharAt(i--);
                    i = Math.max(-1, i-k);
                }
            }else{
                count = 1;
                prev = sb.charAt(i);
            }
            
        }
        
        return sb.toString();
    }
    // public String removeDuplicates(String s, int k) {
    //     StringBuilder sb = new StringBuilder(s);
    //     int count[] = new int[sb.length()];
    //     for (int i = 0; i < sb.length(); ++i) {
    //         if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
    //             count[i] = 1;
    //         } else {
    //             count[i] = count[i - 1] + 1;
    //             if (count[i] == k) {
    //                 sb.delete(i - k + 1, i + 1);
    //                 i = i - k;
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }    
}