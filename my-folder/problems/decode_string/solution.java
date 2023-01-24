class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '[')
                    sb.insert(0, stack.pop());
                stack.pop();
                String x = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) 
                    x =  (stack.pop()-'0')+x;
                int num = Integer.parseInt(x);
                for(int i=0;i<num;i++)
                    for(int j=0;j<sb.length();j++)
                        stack.push(sb.charAt(j));
            }else
                stack.push(c);
        }
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}