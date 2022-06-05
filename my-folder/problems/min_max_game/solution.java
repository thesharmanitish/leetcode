class Solution {
    public int minMaxGame(int[] nums) {
        if(nums.length==1)
            return nums[0];
        List<Integer> aL = IntStream.of(nums).boxed().collect(Collectors.toList());
        
        while(aL.size()>1){
            boolean flag= true;
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<aL.size();i+=2){
                if(flag){
                    res.add(Math.min(aL.get(i), aL.get(i+1)));
                    flag= false;
                }
                
                else{
                    res.add(Math.max(aL.get(i), aL.get(i+1)));
                    flag= true;
                }
            }
            aL = res;
        }
        return aL.get(0);
    }
}