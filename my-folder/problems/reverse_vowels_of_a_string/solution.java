class Solution {
    public String reverseVowels(String s) {
        int start =0, end = s.length()-1, n = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');        
        char[] arr = s.toCharArray();
        while(start<end){
            while(start< n && !set.contains(arr[start]))
                start++;
            while(end >=0 && !set.contains(arr[end]))
                end--;
            if(start<end){
                swap(arr, start, end);
                start++;
                end--;
            }    

        }
        return new String(arr);  
    }
    public void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}