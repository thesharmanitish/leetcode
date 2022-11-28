class Solution {
    Map<Character, Integer> priorityMap = new HashMap<>();
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    int i=0;
    public int calculate(String s) {
        priorityMap.put('-', 1);
        priorityMap.put('+', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
        // s= s.trim().replaceAll(" ", "");
        while(i<s.length() && Character.isWhitespace(s.charAt(i)))
            i++;          
        int num1 = getNumber(s);
        operands.push(num1);
        while(i<s.length()){     

            while(i<s.length() && Character.isWhitespace(s.charAt(i)))
                i++;  
            if(i==s.length())
                break;
            char op = s.charAt(i++);

            while(i<s.length() && Character.isWhitespace(s.charAt(i)))
                i++;
                
            int num2 = getNumber(s);   
                   
            while(!operators.isEmpty() && priorityMap.get(operators.peek())>=priorityMap.get(op)){
                evaluate();
            }
            operators.push(op);
            operands.push(num2);       

        }
        
        while(!operators.isEmpty()){
            evaluate();
        }
        return operands.pop();
    }
    public int getNumber(String s){
        int num1 = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            num1 =num1 *10+(s.charAt(i)-'0');
            i++;
        }
        return num1;
    }
    int res = 0;
    public void evaluate(){
        
        int num4 = operands.pop();
        int num3 = operands.pop();
        char op = operators.pop();
        if(!operators.isEmpty() && operators.peek() == '-')
            num3 *=-1;
        switch(op){
            case '+':  res = num3 + num4; break;
            case '-':  res = num3 -num4; break;
            case '*':  res = num3 * num4; break;
            case '/':  res = num3 / num4; break;
        }
        if(!operators.isEmpty() && operators.peek() == '-')
            res *=-1;
        operands.push(res);
        
    }
}
