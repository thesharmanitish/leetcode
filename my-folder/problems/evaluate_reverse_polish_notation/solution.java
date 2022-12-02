class Solution {
    int i=0;
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
        for(i=0;i<tokens.length;i++){
            if(Character.isDigit(tokens[i].charAt(tokens[i].length()-1)))
                operand.push(Integer.parseInt(tokens[i]));
            else{
                int y = operand.pop();
                int x = operand.pop();

                switch(tokens[i].charAt(0)){
                    case '+': operand.push(x+y); break;
                    case '-': operand.push(x-y); break;
                    case '*': operand.push(x*y); break;
                    case '/': operand.push(x/y); break;
                }
            }
        }
        return operand.pop();
    }
}
