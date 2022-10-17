class Solution {
    public boolean checkIfPangram(String sentence) {
        int vector = 0;
        int check =  (1 << 26) - 1;
        for(char c:sentence.toCharArray()){
            
            vector |= 1<<(c-'a');
            if(vector == check)
                return true;
        }
        
        return false;
    }
}