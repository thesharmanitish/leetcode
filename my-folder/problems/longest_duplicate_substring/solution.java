class Solution {


    
	public String longestDupSubstring(String s) {
		if (s == null || s.length() == 0)
			return s;
         
		int l = 0, r = s.length()-1, i = 0, j = 0, mid=0;
        

		while (l < r) {
			mid = l + (r - l) / 2 +1;
			int t = -1;
         
			if ((t = findDuplicate(s, mid)) == -1) {
				r = mid - 1;

			} else {
				l = mid;
				if (j < mid) {
					j = mid;
					i = t;
				}
			}
		}
		return i > 0 ? s.substring(i, i + j) : "";
	
	
	}

	/**
	 * polynomial rolling hash
	 * 
	 * @param str
	 * @param len
	 * @param map
	 * @return
	 */
	private int findDuplicate(String str, int window) {
		long currHash = 0, multiplier = 1, p = (1 << 31) - 1, base = 26;
        StringBuilder s = new StringBuilder();
		for (int i = 0; i < window; i++) {
			currHash = ((currHash * base)  + str.charAt(i)) % p;
            s.append(str.charAt(i));
		}
        
            
		
		int start = 0;

        
        for (int k = 1; k < window; ++k) {
            multiplier = (multiplier * 26) % p;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(currHash, start);
        for (int i = window; i < str.length() ; i++) {
            
			currHash = ((currHash + p -  multiplier* str.charAt(start++) % p) * base + str.charAt(i)) % p;
            s= s.deleteCharAt(0);
            s.append(str.charAt(i));
            Integer t = map.get(currHash);
			if (t != null && str.substring(t,t+window).equals(s.toString()))
					return start;
			
			map.put(currHash, start);
		}
		map.clear();
		return -1;

		
	
		
	}
}