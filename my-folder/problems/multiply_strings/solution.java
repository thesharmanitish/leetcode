class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()<num2.length())
            return multiply(num2, num1);
        if(num2.equals("0"))
            return "0";
        else if(num2.equals("1"))
            return num1;
        int n = num2.length()-1;
        StringBuilder[] result = new StringBuilder[n+1];
        int max = 0;
        for(int i=n;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n-i;j++)
                sb.append('0');
            int carry = 0;
            for(int j=num1.length()-1;j>=0;j--){
                int res = (num1.charAt(j)-'0')*(num2.charAt(i)-'0')+carry;
                carry = res/10;
                res %= 10;
                sb.insert(0, res);
            }
            if(carry>0)
                sb.insert(0, carry);
            result[i] = sb;
            max = Math.max(sb.length(), max);
        }
        StringBuilder r = new StringBuilder();
        int carry = 0;
        for(int j=max-1;j>=0;j--){
            int out = 0;
            for(int i=0;i<=n;i++){
                if(result[i].length()>0){
                    out+= result[i].charAt(result[i].length()-1)-'0';
                    result[i].setLength(result[i].length()-1);
                }
            }
            out+=carry;
            carry = out/10;
            out %=10;
            r.insert(0,out);
        }
        if(carry>0)
            r.insert(0, carry);
        
        return r.toString();
        

    }
}