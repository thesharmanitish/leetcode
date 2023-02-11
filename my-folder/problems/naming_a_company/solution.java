class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<Integer>[] set = new HashSet[26];
        
        for(String idea:ideas){
            int ind = idea.charAt(0)-'a';
            if(set[ind] == null)
                set[ind] = new HashSet<>();
            set[ind].add(idea.substring(1).hashCode());
        }
        long ans =0;
        for(int i=0;i<25;i++){
            if(set[i] == null)
                continue;
            for(int j=i+1;j<26;j++){
                if(set[j] == null)
                    continue;
                int count1 = 0, count2 = 0;
                for(int hcode: set[i]){
                    if(!set[j].contains(hcode))
                        count1++;
                }
                for(int hcode: set[j]){
                    if(!set[i].contains(hcode))
                        count2++;
                }

                ans += count1*count2;
            }
        }
        return 2*ans;
    }
}