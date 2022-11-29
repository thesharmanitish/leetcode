class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        
        int[] arr = new int[26];
        int[] brr;
        for (String str: B){
            brr = new int[26];
            for(char c:str.toCharArray())
                brr[c - 'a']++;
            for(int i=0;i<26;i++){
                arr[i] = Math.max(arr[i], brr[i]);
            }
        }
        
        for(String str:A){
            brr = new int[26];
            for(char c:str.toCharArray()){
                if(arr[c - 'a']!=0 && arr[c - 'a']> brr[c-'a'])
                    brr[c-'a']++;
            }
            if(Arrays.equals(arr,brr))
                result.add(str);
        }
        return result;

    }
}