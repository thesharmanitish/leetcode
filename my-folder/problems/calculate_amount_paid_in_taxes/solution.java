class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = -1;
        for(int[] b:brackets){
            if(income>b[0]){
                if(prev ==-1)
                    tax += 0.01*b[1]*b[0];
                else
                    tax += 0.01*b[1]*(b[0]-prev);
            }else{
                if(prev !=-1)
                    tax += 0.01*b[1]*(income-prev);
                else
                    tax += 0.01*b[1]*(income);
                return tax;
            }
            prev = b[0];
        }
        return tax;
    }
}