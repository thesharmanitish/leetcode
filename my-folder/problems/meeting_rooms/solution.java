class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int[] prev = new int[]{-1,-1};
        for(int[] interval:intervals){
            if(interval[0] <prev[1])
                return false;
            prev = interval; 
        }
        return true;
    }
}