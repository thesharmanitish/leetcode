class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for(String str:strs){
            long sum=0;
            for(char c:str.toCharArray()){
                sum+=(long) c*(c-1)*(c*c+1)*(7919);
            }
            map.computeIfAbsent(sum, (s)->new ArrayList<>()).add(str);
        }
        
        return map.values().stream().collect(Collectors.toList());
        
//         Map<String,List<String>> map = new HashMap<>();
        
//         for(String s:strs){
//             char[] arr = s.toCharArray();
//             Arrays.sort(arr);
//             String t = String.valueOf(arr);
//             if(map.get(t)!=null){
//                 List<String> x = map.getOrDefault(t, new ArrayList<>());
//                 x.add(s);
//                 map.put(t,x);
//             }else{
//                 List<String> x = new ArrayList<>();
//                 x.add(s);
//                 map.put(t, x);
//             }
//         }
//         return map.values().stream().collect(Collectors.toList());        
    }
}