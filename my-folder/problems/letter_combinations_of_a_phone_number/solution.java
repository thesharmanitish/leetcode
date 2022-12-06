// class Solution {
//     char[][] arr = new char[][]{{},{'a','b','c'},{'d','e','f'},{'g','h','i'}
//     ,{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'},{' '}};

//     public List<String> letterCombinations(String digits) {
//         List<String> result = new ArrayList<>();
//         if(digits.length() ==0)
//             return result;
        
//         result.add("");
//         for(char digit:digits.toCharArray()){
//             result = fun(result, digit-'1');  
//         }
//         return result;
//     }
//     public List<String>  fun(List<String> list, int ind) {
//         List<String> temp = new ArrayList<>();
//         for(int i=0;i<list.size();i++){
//             for(int j=0;j<arr[ind].length;j++){
//                 temp.add(list.get(i) +arr[ind][j]);
//             }
//         }
//         return temp;
//     }
// }

class Solution {

    // Map<Character, String> nums = new HashMap() {
    //     {
    //         put('0', "");
    //         put('1', "");
    //         put('2', "abc");
    //         put('3', "def");
    //         put('4', "ghi");
    //         put('5', "jkl");
    //         put('6', "mno");
    //         put('7', "pqrs");
    //         put('8', "tuv");
    //         put('9', "wxyz");
    //     }
    // };
    char[][] dict = new char[][]{{},{'a','b','c'},{'d','e','f'},{'g','h','i'}
    ,{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'},{' '}};    
    char[] arr;
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return res;
        arr = digits.toCharArray();
        dfs(new StringBuilder(), 0);
        return res;
    }

    private void dfs(StringBuilder sb, int index) {
        if(sb.length() == arr.length){
            res.add(sb.toString());
            return;
        }
        for(char c:dict[arr[index]-'1']){
            sb.append(c);
            dfs(sb, index+1);
            sb.setLength(sb.length()-1);
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