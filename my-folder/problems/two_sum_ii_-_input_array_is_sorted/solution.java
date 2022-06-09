class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start =0, end = numbers.length-1;

        int[] res = new int[2];
        while(start<end){
            if(numbers[end]+ numbers[start]<target)
                start++;
            else if(numbers[end]+ numbers[start]>target)
                end--;
            else{   
                    res[0] = start+1;
                    res[1] = end+1;
                    return res;
                }
        }
        return res;
    }
}