class Solution {
    char[] two={'a','b','c'}, three={'d','e','f'}, four={'g','h','i'}, five = {'j','k','l'}, six = {'m','n','o'}
           ,seven = {'p','q','r','s'}, eight={'t','u','v'}, nine={'w','x','y','z'}, zero = {' '};
    
    public List<String> letterCombinations(String digits) {
        char[] in = digits.toCharArray();
        List<String> res = new ArrayList<>();
        for(char c:digits.toCharArray()){
            switch(c){
                    case '2' :  res = letterCombinations(two, res);break;
                    case '3' :  res = letterCombinations(three, res);break;
                    case '4' :  res = letterCombinations(four, res);break;
                    case '5' :  res = letterCombinations(five, res);break;
                    case '6' :  res = letterCombinations(six, res);break;
                    case '7' :  res = letterCombinations(seven, res);break;
                    case '8' :  res = letterCombinations(eight, res);break;
                    case '9' :  res = letterCombinations(nine, res);break;
                    case '0' :  res = letterCombinations(zero, res);break;
            }
        }
        return res;
    }
    public List<String>  letterCombinations(char[] digits, List<String> res) {
       List<String> tmp = new ArrayList<>();
        
        if(res.size() ==0){
            for(char c:digits){
                tmp.add(""+c);
            }               
        }
        else{
            for(String s:res){
                for(char c:digits){
                    tmp.add(s+c);
                }
            }
        }
        return tmp;
        
    }
}