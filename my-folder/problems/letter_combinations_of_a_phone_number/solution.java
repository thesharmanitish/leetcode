class Solution {

    static Map<Character, String> NUMS = new HashMap() {
        {
            put('0', "");
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(sb, 0, digits, NUMS, res);

        return res;
    }

    private void dfs(StringBuilder sb, int index, String digits, Map<Character, String> nums, List<String> res) {
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        for(char c: nums.get(digits.charAt(index)).toCharArray()){
            sb.append(c);
            
            dfs(sb, index+1, digits, nums, res);
            
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}

// class Solution {
//     char[] 
//         two={'a','b','c'}, 
//         three={'d','e','f'}, 
//         four={'g','h','i'},     
//         five = {'j','k','l'}, 
//         six = {'m','n','o'},
//         seven = {'p','q','r','s'}, 
//         eight={'t','u','v'}, 
//         nine={'w','x','y','z'}, 
//         zero = {' '};
    
//     public List<String> letterCombinations(String digits) {
//         List<String> result = new ArrayList<>();
//         for(char c:digits.toCharArray()){
//             switch(c){
//                 case '2': result = letterCombinations(two, result);break;
//                 case '3': result = letterCombinations(three, result);break; 
//                 case '4': result = letterCombinations(four, result);break;
//                 case '5': result = letterCombinations(five, result);break;
//                 case '6': result = letterCombinations(six, result);break;
//                 case '7': result = letterCombinations(seven, result);break;
//                 case '8': result = letterCombinations(eight, result);break;
//                 case '9': result = letterCombinations(nine, result);break;
//                 case '0': result = letterCombinations(zero, result);break;    
//             }
            
//         }
        
//         return result;
//     }
//     public List<String>  letterCombinations(char[] digits, List<String> res) {
//         List<String> result = new ArrayList<>();
//         if(res.size()==0){
//             for(char n:digits){
//                 result.add(""+n);
                
//             }
//             return result;
//         }
//         for(char n:digits){
//             for(String s:res){
//                 result.add(s+n);
//             }
            
//         }
        
        
//         return result;
        
//     }
// }