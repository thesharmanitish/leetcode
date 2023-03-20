class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String path:paths){
            String prefix = null;
            while(path.length()>1){
                String p = path.substring(0,path.indexOf('('));
                String[] arr = p.split(" ");
                if(prefix ==null)
                    prefix = arr[0];
                p = arr[arr.length-1];
                p = prefix.concat("/"+p).trim();
                String content = path.substring(path.indexOf('(')+1, path.indexOf(')'));
                
                if(!map.containsKey(content))
                    map.put(content, new ArrayList<>());
                
                List<String> v = map.get(content);
                v.add(p);
                
                map.put(content, v);
                path = path.substring(path.indexOf(')')+1);
            }
        }
        
        return map.values().stream().filter(s->s.size()>1).collect(Collectors.toList());
    }
}