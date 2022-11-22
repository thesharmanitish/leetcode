class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<Long, List<String>> map = new HashMap<>();
        // for(String str:strs){
        //     long sum=0; //(long)1<<31;
        //     sum-=1;
        //     for(char c:str.toCharArray()){
        //         // sum += sum*31 + c;
        //         sum+=(long) (c*(c-1)+1<<c)*(1<<31);
        //     }
        //     map.computeIfAbsent(sum, (s)->new ArrayList<>()).add(str);
        // }
        
        // return map.values().stream().collect(Collectors.toList());
        
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            map.computeIfAbsent(t, (x)->new ArrayList<>()).add(s);
        }
        return map.values().stream().collect(Collectors.toList());        
    }
}