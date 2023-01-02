class Solution {
    public int countDigits(int num) {
        if(num<10)
            return 1;
        
        int temp =  num, count = 0;
        // boolean[] arr = new boolean[10];
        while(temp>0){
            int t = temp%10;
            if(num%t ==0 ){
                count++;
            }
            temp /= 10;
            
        }
        return count;
    }
}