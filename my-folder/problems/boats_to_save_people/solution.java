class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0 ,end = people.length-1;
        int boats = 0;
        while(start<=end){
            boats++;
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;            
        }
        return boats;
    }
}