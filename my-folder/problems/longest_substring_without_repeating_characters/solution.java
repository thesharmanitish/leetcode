class Solution {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> set = new LinkedList<>();
        int count = 0, max = 0;
        for(char ch:s.toCharArray()){
            if(!set.contains(ch))
            {    set.addLast(ch);
                count +=1;
            }else{
                int size = set.size();
                for(int i=0;i<size;i++){
                    if(set.getFirst() == ch){
                        set.removeFirst();
                        set.addLast(ch);
                        break;
                    }
                    else{
                        set.removeFirst();
                        count--;
                    }
                }
            }
            
            max= Math.max(max,count);
        }
        return max;
    }
}