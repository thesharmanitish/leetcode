class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(n, 1, new ArrayList<>(), result, new boolean[n+1], k);
        return result;
    }
    public void permuteHelper(int nums, int ind, List<Integer> current, List<List<Integer>> result, boolean[] visited, int k) {
        if(current.size() == k){
            result.add(new ArrayList(current));
            return ;
        }
        for(int i=ind;i<=nums;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            current.add(i);
            permuteHelper(nums, i+1, current, result, visited, k);
            current.remove(current.size()-1);
            visited[i] = false;
        }
            
    }    
}