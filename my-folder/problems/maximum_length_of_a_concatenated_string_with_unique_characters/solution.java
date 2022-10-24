class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        
        dp.add(0);
        int res = 0;
        for(String str:arr){
            int a=0, dup = 0;
            for(char c:str.toCharArray()){
                dup |= a & (1<<(c-'a'));
                a |= 1<<(c-'a');
            }
            if(dup>0)
                continue;
            int n= dp.size();
            for (int i = 0; i <n; i++) {
                if ((dp.get(i) & a) > 0) 
                    continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
            
            
        }
        return res;
            
    }
}