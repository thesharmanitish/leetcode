class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0, end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start<end){
            while(start<end && !Character.isAlphabetic(arr[start]))
                start++;

            while(start<end && !Character.isAlphabetic(arr[end]))
                end--;

            // swap
            swap(arr, start, end);
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
    public void swap(char[] arr, int start, int end){
        char c = arr[start];
        arr[start] = arr[end];
        arr[end] = c;
    }
}