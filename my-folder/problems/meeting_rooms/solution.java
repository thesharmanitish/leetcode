class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean[] arr= new boolean[(1<<20)+1];
        for(int[] i:intervals){
            for(int j=i[0];j<i[1];j++){
                if(arr[j])
                    return false;
            }
            Arrays.fill(arr, i[0],i[1], true)   ;  
        }
        return true;
    }
}