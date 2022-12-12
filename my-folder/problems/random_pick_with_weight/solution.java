class Solution {
    TreeMap<Double, Integer> tmap;
    double sum = 0;
    public Solution(int[] w) {
        sum = IntStream.of(w).sum();
        double prev = 0;
        tmap = new TreeMap<>();
        int i=0;
        for(int weight:w){
            double x = 100*(weight/sum)+prev;
            tmap.put(x, i++);
            prev = x;
        }
    }
    
    public int pickIndex() {
        double rand = new Random().nextDouble()*100;

        // System.out.println(rand +" "+ tmap);
        Map.Entry<Double, Integer> entry = tmap.ceilingEntry(rand);
        return  entry.getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */