class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[256];
        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }
        result = Math.max(arr.length - start, result);

        return result;
    }
    
//     public int lengthOfLongestSubstring(String s) {
//         Deque<Character> set =new LinkedList<>();
//         int max= 0;
//         for(char c:s.toCharArray()){
//             if(set.contains(c)){
//                 max=Math.max(max, set.size());
//                 while(set.pop()!= c);
                    
//                 }
//             set.add(c);
                
//         }
//         return Math.max(max, set.size());
//     }
}