class Solution {
    public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			count[c - 'a']++;
		}
		boolean[] visited = new boolean[26];
		for (char c : arr) {
			count[c-'a']--;
			if(visited[c-'a'])
				continue;
			while ( !stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a']>0) {
				visited[stack.pop()-'a'] = false;
			}
			stack.push(c);
			
			visited[c-'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	
	
	
        
//         int vector=0;
//         for(char c:s.toCharArray()){
//             vector = vector | 1<< c-'a';
//         }
//         System.out.println(vector);
//         StringBuilder sb = new StringBuilder(s.length());
//         int i=0;
//         while(vector!=0){
//             if((vector & 1) ==1)
//             {   char c = (char)('a'+i);
//                 sb.append(c);
//                 }
//             vector>>=1;
//             i++;
//         }
        
//         return sb.toString();
    }
    	private  boolean unstable(Deque<Character> uset, Character in) {

		while (uset.descendingIterator().hasNext())

		{
			Character s = uset.descendingIterator().next();
			if (s < in) {
				return true;
			} else if (s == in) {
				return false;
			}
			
		}
		
		return false;
	}
}