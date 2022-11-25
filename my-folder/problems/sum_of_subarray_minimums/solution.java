
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                dp[i] = (1+i)*arr[i];
            }else{
                int prevSmaller = stack.peek();
                dp[i] = dp[prevSmaller] + (i-prevSmaller)*arr[i]%MOD;
            }
            stack.push(i);

        }
        long sum = 0;
        for(int i=0;i<dp.length;i++){
            sum += dp[i];
            sum%=MOD;
        }
        return (int) sum;

    }


    // long sum = 0;

    // Stack<Integer> stack = new Stack<>();
    // for(int i=0;i<=arr.length;i++){
        
    //     while(!stack.isEmpty() && (arr.length ==i || arr[stack.peek()] >= arr[i])){
    //         int mid = stack.pop();
    //         int left = stack.isEmpty()?-1:stack.peek();
    //         int right = i;

    //         long s = (mid-left)*(right-mid)%MOD;
    //         sum += s*arr[mid];
    //         sum%=MOD;
    //     }
    //     stack.push(i);

    //     }
    //     return (int)sum;
        
    // }



    // public int checkBoundry(int[] arr, int i) {
    //     int x = arr[i], len = 1, t = i, left = 0, right =0;
    //     while(i+1 < arr.length && arr[++i]>=x)
    //         right++;
    //     while(t>=1 && arr[--t]>x)
    //         left++;
    //     len+=left+right;
    //     len+=left*right;
    //     return len;

    // }
}