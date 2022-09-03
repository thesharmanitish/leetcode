class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> results = new ArrayList<Integer>();        
        for(int i=1;i<10;i++){
            dfs(n- 1, i, k, results);
        }
        
        return results.stream().mapToInt(i->i).toArray();
    }
    protected void dfs(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);        
        
        for(Integer nextDigit: nextDigits){
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                dfs(N - 1, newNum, K, results);
            }            
        }
        
    }
}