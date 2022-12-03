class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int n = beginWord.length();
        wordList.stream().forEach(s->{
            for(int i=0;i<n;i++){
                String temp = s.substring(0,i)+'*'+s.substring(i+1);
                map.computeIfAbsent(temp, (k)->new ArrayList<String>()).add(s);
            }
        });

        Queue<String> bfs = new LinkedList<>();
        bfs.add(beginWord);
        int count=1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-->0){
                String t = bfs.poll();
                if(t.equals(endWord))
                    return count;
                
                for(int i=0;i<n;i++){
                    String temp = t.substring(0,i)+'*'+t.substring(i+1);
                    List<String> lString = map.get(temp);
                    if(lString ==null)
                        continue;
                    for(String s:lString){
                         if(visited.contains(s))
                            continue;
                        bfs.add(s);
                        visited.add(s);
                    }
                }

            }
            count++;
        }
        return 0;
    }
}

















/**
// class Pair{
//     String str;
//     List<String> list;
//     public Pair(String str,List<String> l){
//         this.str = str;
//         this.list = l;
//     }
// }
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Integer> dict = new HashMap<>();
		int i = 0;
		for (String word : wordList)
			dict.put(word, i++);
		Queue<String> bfs = new LinkedList<>();

		bfs.add(beginWord);
		boolean[] visited = new boolean[wordList.size()];
        int count = 1;
		while (!bfs.isEmpty()) {
            int size = bfs.size();
            for(i=0;i<size;i++){
                String str = bfs.poll();
                if (str.equals(endWord)) {
                    return count;
                }
                Integer ind = dict.get(str);
                if(ind !=null)
                    visited[ind] = true;
                for (String word : wordList) {
                    if (visited[dict.get(word)] || !checkValid(str, word) || Math.abs(str.compareTo(word))>20)
                        continue;
                    bfs.offer(word);
                }
                wordList.remove(dict.get(str));
            }
            count++;
		}
		return 0;
    }
    public boolean checkValid(String a, String b){
        int count =0;
        for(int i=0;i<a.length();i++){
            count += (a.charAt(i) ^ b.charAt(i))>0?1:0;
            if(count>1)
                return false;
        }
        return count ==1;
    }
}
 */