class Solution {
    //s = [1,3,1,2]
    /**
        psum = 0, 1, 4, 5, 7
        ppsum = 0, 0 , 1, 5, 9, 16

        for i = 0

        total = s[0] + s[0] +s[1] * s[0]
             = psum(i+1) - psum(left[i]+1) +
               psum(i+2) - psum(left[i]+1) +
             = (i-left[i]+1)* (psum[i+1] +psum[i+2] ) -
               (right[i]- i-1) * (psum(left[i]+1) +psum(left[i]+1) ) * s[i]
    
      
    */
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int MOD = 1_000_000_007;
        long[] psum = new long[n+1], ppsum = new long[n+2];

        for(int i=0;i<n;i++){
            psum[i+1] = (psum[i] + strength[i])%MOD;
            ppsum[i+1] = (ppsum[i] + psum[i])%MOD;
        }
        ppsum[n+1] = (ppsum[n] + psum[n])%MOD;

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+= ((ppsum[right[i] + 1] - ppsum[i + 1]) * (i - left[i]) % MOD + MOD * 2 -
                    (ppsum[i + 1] - ppsum[left[i] + 1]) * (right[i] - i) % MOD) * strength[i];
            sum %= MOD;
        }
        return (int)sum;
        
    }
}