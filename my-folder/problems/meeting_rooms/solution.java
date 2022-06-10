class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)-> {return o1[0]-o2[0];});
        
        int prev = -1;
        for(int[] a:intervals){
            if(prev ==-1)
                prev = a[1];
            else{
                if(a[0]<prev)
                    return false;
                prev = a[1];
            }
            
        }
        
        return true;
    }
}