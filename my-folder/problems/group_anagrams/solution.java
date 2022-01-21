class Solution {
    
        public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    
//        public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, Integer> m = new HashMap<>();
//         List<List<String>> ans = new ArrayList<List<String>>();
//         for(String tmp: strs){
//             char[] chars = tmp.toCharArray();
//             Arrays.sort(chars);
//             String key = new String(chars);
//             if(m.containsKey(key)){
//                 int index =  m.get(key);
//                 List<String> l = ans.get(index);
//                 l.add(tmp);
//                 ans.set(index, l);
//             }
//             else {
//                 List<String> nl = new ArrayList<>();
//                 nl.add(tmp);
//                 ans.add(nl);
//                 m.put(key, ans.size()-1);
//             }
//         }
//         return ans;
        
//     }
//   public List<List<String>> groupAnagrams(String[] strs) {
// //	    	List<List<String>> res = new ArrayList<>();
// 	    	Map<Integer,List<String>> map = new HashMap<>();
	    	
// 	    	for(String s:strs) {
// 	    		if(map.isEmpty()) {
// 	    			List<String> ana = new ArrayList<>();
// 	    			ana.add(s);
// 	    			map.put(sum(s),ana);
// 	    			continue;
// 	    		}
// 	    		boolean flag = false;
// 	    		String tem = "";
// 	    		if(map.containsKey(sum(s))) {
// 		    		for(char ch:s.toCharArray()) {
// 		    			List<String> data = map.entrySet().stream().filter(e -> sum(s)==e.getKey())
// 		    			  .map(Map.Entry::getValue).findFirst().get();
// 		    			tem = data.get(0);
// 		    			if(tem.length()!=s.length()){
// 		    				flag = true;
// 		    				break;
// 		    			}
// 		    			for(char c:tem.toCharArray()) {
		    				
// 		    				if(!s.contains(String.valueOf(c))) {
// 			    				flag = true;
// 			    				break;
// 		    				}
		    				
// 		    			}
		    			
// 		    		}
// 		    		if(!flag)
// 		    			map.get(sum(tem)).add(s);
// 	    		}
// 	    		else {
// 	    			List<String> ana = new ArrayList<>();
// 	    			ana.add(s);
// 	    			map.put(sum(s),ana);
// 	    		}
//     			if(flag) {
//         			List<String> ana = new ArrayList<>();
// 	    			ana.add(s);
// 	    			map.put(sum(s),ana);
//     			}
// 	    	}
// 	    	return map.entrySet().stream().map(v->v.getValue()).collect(Collectors.toList());
// 	    }
	
// 	private int sum(String s) {
// 			// TODO Auto-generated method stub
// 		int sum = 0;
// 			for(char ch:s.toCharArray())
// 				sum+=ch;
// 			return sum;
// 		}

}