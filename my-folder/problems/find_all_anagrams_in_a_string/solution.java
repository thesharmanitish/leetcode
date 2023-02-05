class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length(), i=0;
        List<Integer>  result = new ArrayList<>();
        if(n>s.length())
            return result;
        int[] arr = new int[26];
        int[] allZero = new int[26];
        for(i=0;i<n;i++){
            arr[s.charAt(i)-'a'] -=1;
            arr[p.charAt(i)-'a'] +=1;
        }

        int j= 0 ;
        if(Arrays.equals(arr, allZero))
            result.add(j);

        
        for(;i<s.length();i++){
            arr[s.charAt(j++)-'a'] += 1;
            arr[s.charAt(i)-'a'] -= 1;
            if(Arrays.equals(arr, allZero))
                result.add(j);            
        }
        return result;
    }
}