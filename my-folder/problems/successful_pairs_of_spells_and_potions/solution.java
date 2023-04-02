class Solution {
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		Arrays.sort(potions);
		TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE, potions.length);
		for (int i = potions.length - 1; i >= 0; i--) {
			map.put((long) potions[i], i);
		}
		for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
			spells[i] = potions.length - map.ceilingEntry(need).getValue();
		}
		return spells;
	}
}

// class Solution {
//     public int[] successfulPairs(int[] spells, int[] potions, long success) {
//         Arrays.sort(potions);
//         int x = 0;
//         int[] count = new int[spells.length];
//         for(int i=spells.length-1;i>=0;i--){
//              count[i] = potions.length - bsearch(potions, spells[i], success);
//         }
//         return count;
//     }

//     public int bsearch(int[] potions, int spell, long success) {
//         int left = 0, right = potions.length;

//         while(left<right){
//             int mid = left +(right-left)/2;
//             long x = (long)spell * potions[mid];
//             if(x< success){
//                 left = mid+1;
//             }else{
//                 right = mid;
//             }
//         }
//         return left==potions.length?potions.length:left;

//     }
// }