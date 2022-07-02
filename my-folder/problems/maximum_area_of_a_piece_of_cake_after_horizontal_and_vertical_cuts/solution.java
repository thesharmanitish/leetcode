class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxRow =0, maxCol = 0, prev =0;
        for(int n:horizontalCuts){
                maxRow =  Math.max(maxRow, n - prev);
                prev = n;
        }
        maxRow = Math.max(maxRow, h-prev);
        
        prev = 0;
        for(int n:verticalCuts){
                maxCol =  Math.max(maxCol, n - prev);
                prev = n;
        }
        long M = 1000000007;
        maxCol =  Math.max(maxCol, w - prev);
        return (int)(((long)maxRow%M *maxCol%M) % M);
    }
}