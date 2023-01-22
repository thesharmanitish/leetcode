class Solution {
    public List<List<String>> partition(String s) {
        partition(s, new ArrayList<>());
        return result;
    }
    List<List<String>> result = new ArrayList<>();
    public void partition(String s, List<String> current) {
        if(s.length()==0)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<s.length();i++){
            String pre = s.substring(0, i+1);
            if(!isPalindrome(pre))
                continue;
            
            current.add(pre);
            String post = s.substring(i+1);
            partition(post, current);
            current.remove(current.size()-1);
        }
    }
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }

}