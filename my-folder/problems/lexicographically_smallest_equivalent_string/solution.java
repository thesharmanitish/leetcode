class DSU{
    int[] root;

    public DSU(int n){
        root = new int[n];

        for(int i=0;i<n;i++){
            root[i] = i;
        }
    }

    public int find(int x){
        if(root[x] ==x)
            return x;
        return x = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX<rootY){
            root[rootY] = rootX;
        }else{ 
            root[rootX] = rootY;
        }

    }    
}
class Solution {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        DSU dsu = new DSU(26) ;
        for(int i=0;i<n;i++){
            int c1 = s1.charAt(i)-'a', c2 = s2.charAt(i)-'a';
            dsu.union(c1, c2);
        }
        StringBuilder result = new StringBuilder();

        for(char c:baseStr.toCharArray()){
            result.append((char)(dsu.find(c-'a')+'a'));
        }
        return result.toString();
    }



}