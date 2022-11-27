class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int yes =0, no= 0;
        for(char c:customers.toCharArray())
            yes+=c=='Y'?1:0;
        if(yes ==0)
            return 0;
        no = 0;
        int min = yes, ind = 0;
        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1) =='Y'){
                yes -=1;
            }else{
                no +=1;
            }
            int sum = yes+no;
            if(min>sum){
                min =sum;
                ind = i;
            }
            // min = Math.min(min, sum);
        }
        return ind;
        
    }
}