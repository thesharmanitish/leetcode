class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2)-> {return o2[0]-o1[0] ==0?o1[1]-o2[1]:o2[0]-o1[0];});
        List<int[]> pList = new LinkedList<>();   
        int i=0;
        for(int[] t:people){
            pList.add(t[1], t);
            
        }
        int n= people.length;
        return pList.toArray(new int[n][2]);
    }
}