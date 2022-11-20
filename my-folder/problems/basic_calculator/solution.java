class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                operand =operand*10 + c-'0';
            }else if(c == '+'){
                result += operand * sign;
                sign = 1;
                operand = 0;
            }else if(c == '-'){
                result += operand * sign;
                sign = -1;
                operand = 0;
            }else if(c=='('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(c==')'){
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }


            
        }
        return result + (sign * operand);
    }
}















// class Solution {
//     public int calculate(String s) {
//         // s = s.replaceAll(" ", "");
//         Stack<Character> stack = new Stack<>();
//         int i=0;
//         Stack<Character> stack2= new Stack<>();
//         for(char c:s.toCharArray()){
                
//             if(c==')'){
                
//                 char x = stack.pop();
//                 while(x!= '('){
//                     stack2.push(x);
//                     x = stack.pop();
//                 }
                
//                 String data = String.valueOf(evaluate(stack2));
//                 for(char cx:data.toCharArray())
//                     stack.push(cx);
//             }else if(c == ' ')
//                 continue;
//             else
//                 stack.push(c);
//             i++;
//         }

//         stack2.clear();
//         if(!stack.isEmpty()){
//             while(!stack.isEmpty() && stack.peek()!= '('){
//                 stack2.push(stack.pop());
//             }
//         }
//         return evaluate(stack2);
//     }
//     public int evaluate(Stack<Character> stack2){
//         int res = 0;
//         while(!stack2.isEmpty()){
//             int digit = 0;
//             if(Character.isDigit(stack2.peek())){
                
//                 while(!stack2.isEmpty() && Character.isDigit(stack2.peek())){
//                     digit = digit*10+ stack2.pop()-'0';
//                 }
//                 res +=digit;
//             }else{
//                 int pos = 1;
//                 if(stack2.pop() =='+'){
//                     pos =1;
//                     while(!stack2.isEmpty() && !Character.isDigit(stack2.peek())){
//                         pos = pos * (Character.valueOf(stack2.pop()) =='+'?1:-1);
//                     }
//                     while(!stack2.isEmpty() && Character.isDigit(stack2.peek())){
//                         digit = digit*10+ stack2.pop()-'0';
//                     }
//                     if(pos>0)
//                         res += digit;   
//                     else 
//                         res -= digit;
//                 }else{
//                     pos = -1;
//                     while(!stack2.isEmpty() && !Character.isDigit(stack2.peek())){
//                         pos = pos * (Character.valueOf(stack2.pop()) =='+'?1:-1);
//                     }                    
//                     while(!stack2.isEmpty() && Character.isDigit(stack2.peek())){
//                         digit = digit*10+ stack2.pop()-'0';
//                     }
//                     if(pos>0)
//                         res += digit;   
//                     else 
//                         res -= digit; 
//                 }
//             }
//             digit = 0;
//         }
//         return res;
//     }
// }