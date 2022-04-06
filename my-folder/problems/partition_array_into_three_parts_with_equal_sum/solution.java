class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        boolean allPos = true;
        for(int a:arr){
            sum+=a;
            if(a<0)
                allPos = false;
        }
        if(sum==0 && allPos)
            return true;
        if(sum%3 !=0) 
            return false;
        sum /=3;
        
        int  tsum =0, count =0 ;
        for(int i=0;i<arr.length;i++){
            tsum+=arr[i];
            if(tsum==sum){
                count++;;
                tsum = 0;
            }
            
        }
        if(count >=3)
            return true;
        return false;
    }
}