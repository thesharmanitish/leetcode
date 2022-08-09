class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n<=1)
            return "";
        int mid = n/2-1;
        if(n%2==0)
           mid = (n-1)/2;
        boolean flag = false;
        char[] arr = palindrome.toCharArray();
        for(int i=0;i<=mid;i++){
            if(arr[i]!='a'){
                arr[i] = 'a';
                flag= true;
                break;
            }
        }
        if(flag)
            return String.copyValueOf(arr);
        arr[n - 1] = 'b';
//         if(n%2==1)
//             mid +=1;
//         for(int i=n-1;i>mid;i--){
//             if(arr[i] != 'z') {
//                 arr[i] += 1;
//                 flag = true;
//                 break;
//             }  
                
//         }
            return String.copyValueOf(arr);
            
    }
}