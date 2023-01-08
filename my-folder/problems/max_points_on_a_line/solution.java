class Solution {
    public int maxPoints(int[][] points) {
        
        int max = 0;
        for(int[] point1:points){
            Map<Double, Integer> map = new HashMap<>();
            for(int[] point2:points){
                if(point1[0] == point2[0] && point1[1] == point2[1])
                    continue;
                double  t = Math.atan2((point2[1]-point1[1]),(point2[0]-point1[0]));
                map.put(t, map.getOrDefault(t, 0)+1);
            }
            max = Math.max(max, map.isEmpty()?1:Collections.max(map.values()) + 1);
        }
        return max;
    }
}