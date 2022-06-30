class Solution {
    public boolean isHappy(int n) {
        int slow =n, fast = n;
        
        
        do{
            slow =digitSquareSum(slow);
            fast =digitSquareSum(fast);
            fast =digitSquareSum(fast);
        }while(slow != fast);
        if(slow ==1) return true;
        return false;
        
    }
    public int digitSquareSum(int n) {
        
        int sum = 0;
        while(n>0){
            int x = n%10;
            n /= 10;
            sum+=square(x);
        }
        return sum;
            
    }
    public int square(int n) {
        switch(n){
            case 0: return 0;
            case 1: return 1;
            case 2: return 4;
            case 3: return 9;
            case 4: return 16;
            case 5: return 25;
            case 6: return 36;
            case 7: return 49;
            case 8: return 64;
            case 9: return 81;
        }
        return -1;
    }
}