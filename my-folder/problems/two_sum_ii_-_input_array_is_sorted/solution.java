class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0, end = numbers.length-1;
        int[] res = new int[2];
         if(numbers[end-1]+numbers[end]<target)
                return res;        
        while(start<end){          
            if(numbers[start]+numbers[end]>target){
                end--;
            }else if(numbers[end]+numbers[start]<target){
                start++;
            }else {
                res[0] =start+1;
                res[1] =end+1;
                return res;
            }
            
                
        }
        if(target==numbers[start] && start == end){
            res[0] =start+1;
            res[1] =end+1;
        }
        return res;
    }
}