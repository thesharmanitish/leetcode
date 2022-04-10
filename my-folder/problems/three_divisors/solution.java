class Solution {
    public boolean isThree(int n) {
        if(n<3)
            return false;
        List<Integer> al = Arrays.asList( 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 );
        int sqrt = (int)Math.sqrt(n);
        return (sqrt*sqrt) ==n && al.contains(sqrt);
    }
}