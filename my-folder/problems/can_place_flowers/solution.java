class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count1 = 0, count2 = 0;
        boolean flag = false;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 1){
                count1 = Math.max(count1, count2);
                count2 = count1;
                continue;
            }
            else{
                if((i>0 && flowerbed[i-1] ==1) || (i<flowerbed.length-1 && flowerbed[i+1]==1))
                    continue;
                if(flag)
                    count1++;
                else count2++;
            }
            flag = !flag;
            if(count1>=n || count2>=n)
                return true;
        }
        return count1>=n || count2>=n;
    }
}