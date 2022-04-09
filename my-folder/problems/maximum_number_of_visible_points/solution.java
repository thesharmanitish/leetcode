class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int count = 0;
        List<Double> angles = new ArrayList<>();
        for(List<Integer> p:points){
            int dx = p.get(0) - location.get(0) ;
            int dy = p.get(1) - location.get(1) ;
            if(dx==0 && dy ==0){
                count++;
                continue;}
            double a = Math.atan2(dy,dx)*(180/Math.PI);
                                   
            angles.add(a);
                                   
        }
                                   
        Collections.sort(angles);
        List<Double> temp = new ArrayList<>(angles);
        for(double t:temp){
            angles.add(t+360);
        }
        int res = 0;
        for(int i=0,j=0;i<angles.size();i++){
            while(angles.get(i)-angles.get(j)>angle){
                j++;
            }
            res = Math.max(res, i-j+1);
        }
                                   
        return res+count;
    }
}