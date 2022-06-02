class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if(map.get(t)!=null){
                List<String> x = map.getOrDefault(t, new ArrayList<>());
                x.add(s);
                map.put(t,x);
            }else{
                List<String> x = new ArrayList<>();
                x.add(s);
                map.put(t, x);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> ll:map.values()){
            res.add(ll);
        }
        return res;
    }
}