class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int vector = 0, ref = 0, i = 0;
        if(s1.length()> s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        char[] brr = s1.toCharArray();
        Arrays.sort(brr);
        for(i = 0;i<s1.length();i++){
            vector =vector ^ (1<<(s1.charAt(i)-'a'));
            ref = ref ^ (1<<(s2.charAt(i)-'a'));
        }
        char[] arr = s2.substring(0,i).toCharArray();
        Arrays.sort(arr);        
        if(ref == vector && Arrays.equals(arr, brr))
            return true;
        int j=0;
        for(;i<s2.length();i++ ){
            ref = (1<<(s2.charAt(i)-'a')) ^ref ^ (1<<(s2.charAt(j)-'a'));
            arr = s2.substring(j+1,i+1).toCharArray();
            Arrays.sort(arr);
            if(ref == vector && Arrays.equals(arr, brr))
                return true;
            j++;
        }
        return false;


    }
}