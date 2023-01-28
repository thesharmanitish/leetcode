class SummaryRanges {
    TreeSet<Integer> values;
    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {       
        if(values.isEmpty())
            return new int[][]{{}};
        int prev = -1, last = prev;
        List<int[]> result = new ArrayList<>();
        for(int value:values){
            if(prev ==-1){
                prev = value;
                last = value;
            }else if(last+1==value){
                last = value;
            }else{
                result.add(new int[]{prev, last});
                prev = last = value;
            }
        }
        result.add(new int[]{prev, last});
        return result.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */