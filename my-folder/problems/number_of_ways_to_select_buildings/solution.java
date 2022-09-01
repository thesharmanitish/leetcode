class Solution {
    public long numberOfWays(String s) {
        char[] arr = s.toCharArray();
        
        int oneCount = 0, zeroCount = 0;
        for(char c:arr){
            if(c=='1')
                oneCount +=1;
        }
        zeroCount = arr.length - oneCount;
        
        
        int curZero = arr[0] == '0'?1:0;
        int curOne =  arr[0] == '1'?1:0;
        long sum =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] =='0'){
                sum = sum+ curOne*(oneCount-curOne);
                curZero++;
            }else{
                sum = sum+ curZero*(zeroCount-curZero);
                curOne++;
            }
        }
        return sum;
    }
}