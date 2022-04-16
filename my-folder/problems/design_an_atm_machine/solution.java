class ATM {
    int[] denom = {20,50,100,200,500};
    long[]  N = {0,0,0,0,0};
    public ATM() {
      
    }
    
    public void deposit(int[] banknotesCount) {
        int i=0;
        for(int notes: banknotesCount)
            N[i++] += notes;
    }
    
    public int[] withdraw(int amount) {
        int[] res = {0,0,0,0,0};
        for(int i=4;i>=0;i--){
            if(amount >=denom[i] && N[i]>0){
                res[i]= (int) Math.min(amount/denom[i],N[i]);
                amount -= denom[i] * res[i];
                
            }
        }
        if(amount != 0){
            return new int[] {-1};
        }
        int i=0;
        for(int n:res)
            N[i++] -=n ;           
        return res;

        
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */