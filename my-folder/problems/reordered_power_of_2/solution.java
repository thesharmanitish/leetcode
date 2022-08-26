class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] ca=(N+"").toCharArray();
        return helper(ca, 0, new boolean[ca.length], new HashSet<Integer>());
    }
    public boolean helper(char[] ca, int cur, boolean[] used, HashSet<Integer> vis){
        if (!vis.add(cur)) return false;
        if (cur!=0 && (cur+"").length()==ca.length){
            if (Integer.bitCount(cur)==1) return true;
            return false;
        }
        for (int i=0; i<ca.length; i++){
            if (used[i]) continue;
            used[i]=true;
            if (helper(ca, cur*10+ca[i]-'0', used, vis)) return true;
            used[i]=false;
        }
        return false;
    }
}

// class Solution {
//     public boolean reorderedPowerOf2(int n) {
//         String s = String.valueOf(n);
//         return isPowerOf2(sortString(s));
//     }
//     public String sortString(String str) {
//         char []arr = str.toCharArray();
//         Arrays.sort(arr);
//         return String.valueOf(arr);
//     }
//     public boolean isPowerOf2(String n) {
//         switch(n){
//             case "1" :
//             case "2" :
//             case "4" :
//             case "8" :
//             case "16" :
//             case "23" :
//             case "46" :
//             case "128" :
//             case "256" :
//             case "125" :
//             case "0124" :
//             case "0248" : 
//             case "0469" :
//             case "1289" :
//             case "13468" :
//             case "23678" :
//             case "35566" :
//             case "011237" :
//             case "122446" :
//             case "224588" :
//             case "0145678" :
//             case "0122579" :
//             case "0134449" :
//             case "0368888" :   
//             case "11266777" :   
//             case "23334455" :   
//             case "01466788" :   
//             case "112234778" :   
//             case "234455668" :     
//             case "012356789" :     
//             // case "1073741824" :     
//                 return true; 
//         }
//         return false;
//     }
// }