class Solution {
    public int romanToInt(String s) {
        StringBuilder result = new StringBuilder();
        if(s.length()==1)
            evaluate(s.charAt(0));
        int sum = 0;
        int prev = -1;
        for(int i=s.length()-1;i>=0;i--){
            int cur = evaluate(s.charAt(i));
            if(cur<prev){
                sum-= cur;
            }else
                sum+=cur;
            
            prev = cur;
        }
        return sum;
    }
    public int evaluate(char c){
        int result = 0;
        switch(c){
            case 'I': result = 1; break;
            case 'V': result = 5; break;
            case 'X': result = 10; break;
            case 'L': result = 50; break;
            case 'C': result = 100; break;
            case 'D': result = 500; break;
            case 'M': result = 1000; break;
        }
        return result;

    }

}