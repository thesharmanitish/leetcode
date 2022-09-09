class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        if(properties.length<=1)
            return 0;
        Arrays.sort(properties, (a,b) -> {return a[0] ==b[0]? b[1]-a[1]:a[0]-b[0];});
        int count =0;
        int maxDefense = 0;
        for(int i=properties.length-1;i>=0;i--){
            if(properties[i][1] < maxDefense)
                count++;
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return count;
    }
}