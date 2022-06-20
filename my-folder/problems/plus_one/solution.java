class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry+ digits[i]>9){
                digits[i] = 0;
            }else{
                digits[i] +=carry;
                carry = 0;
                break;
            }
        }
        if(carry>0){
            int[] res = new int[digits.length+1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = carry;
            return res;
        }
            
        return digits;
    }
}