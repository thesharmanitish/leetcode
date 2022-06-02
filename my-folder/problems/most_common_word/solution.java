// class MyTrie{
    
//     class Node{
//         Node[] next;
//         Object value;
//         public Node(Object ob){
//             next = new char[256];
//             value = null;
//         }
//     }
    
//     Node root;
//     private char[] m_charBuffer = new char[0];
//     public MyTrie(){
//         root = new Node();
//     }
// }
class Solution {
    
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] arr = paragraph.replaceAll("\\W+"," ").toLowerCase().split("\\s+");
        
        for(String a:arr){
            if(!set.contains(a)){
                map.put(a, map.getOrDefault(a,0)+1);
            }
        }
        int max = 0;
        String mStr ="";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                mStr = entry.getKey();
            }
        }
        return mStr;
    }
}