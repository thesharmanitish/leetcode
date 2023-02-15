class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}

// class Solution {
//     public List<Integer> addToArrayForm(int[] num, int k) {
//         List<Integer> ans = new ArrayList<>(num.length);
        
//         int n = num.length-1, carry = 0;
//         while(n>=0 && k>0){
//             int sum = num[n--] + carry + (k%10);
//             carry = sum /10;
//             k /= 10;
//             sum = sum %10;
//             ans.add(0, sum);
//         }
//         while(k > 0){
//             int sum = (k%10) + carry;
//             carry = sum /10;
//             k /= 10;
//             sum = sum %10;
//             ans.add(0, sum);
//         }

//         while(n>= 0){
//             int sum = num[n--] + carry;
//             carry = sum /10;
//             sum = sum %10;
//             ans.add(0, sum);
//         }
//         if(carry>0)    
//             ans.add(0, carry);
//         return ans;

//     }
// }