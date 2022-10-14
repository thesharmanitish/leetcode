class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String,Integer> map = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length != pattern.length())
            return false;
        int[] arr = new int[256];
        
        for(int i=0;i<str.length;i++){
            if(map.getOrDefault(str[i], 0) != arr[pattern.charAt(i)])
                return false;
            map.put(str[i], i+1);
            arr[pattern.charAt(i)] = i+1;
        }
        return true;
    }
}