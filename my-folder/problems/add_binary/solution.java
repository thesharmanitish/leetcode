class Solution {
    public String addBinary(String a, String b) {
        long num = 0, carry = 0;
        StringBuilder result = new StringBuilder();
        int n = a.length(), m = b.length();
        if(n<m)
            return addBinary(b, a);
        int c = n-1, d = m-1, shift =0;
        for(int i=m-1;i>=0;i--){
            
            int x = a.charAt(c--);
            int y = b.charAt(d--);

            long temp = (x-'0') ^ (y-'0') ^ carry;
            result.insert(0, temp);
            carry = (((x-'0') ^ (y-'0')) & carry) | ((x-'0') & (y-'0'));
        }

        for(int i=c;i>=0;i--){
            int x = a.charAt(i);

            long temp = (x-'0') ^ carry;
            result.insert(0, temp);
            carry = (x-'0') & carry;          
        }
        if(carry !=0){
            carry = carry <<shift;
            result.insert(0, carry);
        }
        return result.toString();
    }
}