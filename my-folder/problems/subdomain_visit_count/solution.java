class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>(); 
        Map<String, Integer> map =new HashMap<>();
        for(String str:cpdomains){
            String[] s = str.split(" ");
            map.put(s[1], map.getOrDefault(s[1],0)+Integer.parseInt(s[0]));
            while(s[1].indexOf(".") !=-1){
                s[1]= s[1].substring(s[1].indexOf(".")+1);
                map.put(s[1], map.getOrDefault(s[1],0)+ Integer.parseInt(s[0]));
            }
        }
        for(Map.Entry<String, Integer> m:map.entrySet()){
            res.add(m.getValue()+" "+m.getKey());
        }
        return res;
    }
}