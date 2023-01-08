class Solution {
    public boolean confusingNumber(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        StringBuilder num = new StringBuilder();
        for(char c:arr){
            if(c == '2' || c== '3' || c == '4' || c=='5' || c =='7')
                return false;
            switch(c){
                case '0' : num.insert(0,'0'); break;
                case '1' : num.insert(0,'1'); break;
                case '6' : num.insert(0,'9'); break;
                case '8' : num.insert(0,'8'); break;
                case '9' : num.insert(0,'6'); break;
            }
        }
        return num.toString().equals(String.valueOf(arr))? false:true;
    }
}