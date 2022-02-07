class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return null;
        List<List<Integer>> ll = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList();
        c.add(1);
        ll.add(c);
        if(numRows ==1) return ll;
        c = new ArrayList();
        c.add(1);
        c.add(1);
        ll.add(c);
        if(numRows ==2) return ll;
        for(int i=2;i<numRows;i++){
            List<Integer> prev = ll.get(i-1);
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for(int j=1;j<i;j++){
                int sum = prev.get(j-1)+prev.get(j);
                l.add(sum);
                
                
                
                
            }l.add(1);
            ll.add(l);
            
            
        }
        
        return ll;
    }
}