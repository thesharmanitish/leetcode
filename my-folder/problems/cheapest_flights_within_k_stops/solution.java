class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        boolean dstnPresent = false;
        for(int[] flight:flights){
            if(flight[1] == dst)
                dstnPresent = true;            
            map.computeIfAbsent(flight[0], ArrayList::new). add(new Integer[]{flight[0], flight[1], flight[2]});
        }
        if(map.get(src)==null || !dstnPresent)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int count = 0;
        while(k-->=0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] departureAiport = queue.poll();
                int distanceUptil = departureAiport[1];

                List<Integer[]> arrivalAirports = map.get(departureAiport[0]);

                if(arrivalAirports == null || arrivalAirports.size()<1)
                    continue;

                for(Integer[] arrivalAirport:arrivalAirports){
                    if(arrivalAirport[2]+distanceUptil> cost[arrivalAirport[1]])
                        continue;
                    cost[arrivalAirport[1]] = Math.min(arrivalAirport[2]+distanceUptil, cost[arrivalAirport[1]]);
                    queue.add(new int[]{arrivalAirport[1], cost[arrivalAirport[1]]});
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE?-1:cost[dst];

    }
}