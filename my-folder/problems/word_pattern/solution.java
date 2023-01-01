class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        int i = 0;
        if(pattern.length() ==1){
            return true;
        }

        for(String str:s.split(" ")){
            if(pattern.length()==i)
                return false;
            if(!map.containsKey(str)){
                if(map.containsValue(pattern.charAt(i)))
                    return false;
                map.put(str, pattern.charAt(i));
            }else if(map.get(str) != pattern.charAt(i)){
                return false;
            }
            i++;
        }
        if(pattern.length()>i)
            return false;        
        return true;  
    }
}
  

//   class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         Map<String,Integer> map = new HashMap<>();
//         String[] str = s.split(" ");
//         if(str.length != pattern.length())
//             return false;
//         int[] arr = new int[256];
        
//         for(int i=0;i<str.length;i++){
//             if(map.getOrDefault(str[i], 0) != arr[pattern.charAt(i)])
//                 return false;
//             map.put(str[i], i+1);
//             arr[pattern.charAt(i)] = i+1;
//         }
//         return true;
//     }
// }