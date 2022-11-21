class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans= new StringBuilder();                  
        
        for(int i=0;i<nums.length;i++){
            ans.append(nums[i].charAt(i)=='0'?'1':'0');
        }
        return ans.toString();
    }
}

// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         if(nums.length==1){
//             if(nums[0].equals("1"))
//                 return "0";
//             if(nums[0].equals("0"))
//                 return "1";
//         }
//         String x = nums[0];
//         int n = x.length();
//         int t = 1<<(n-1);
//         Set<String> set = new HashSet<>();
//         for(String num:nums){
//             set.add(num);
//         }
//         while(set.contains((Integer.toBinaryString(t))))
//             t++;
//         String res = Integer.toBinaryString(t);
//         if(res.length()<n){
//             int diff = n-res.length();
//             while(diff-->=0){
//                 res = "0"+res;
//             }
//         }
//         return res.length()>n?res.substring(1):res;
//     }
// }