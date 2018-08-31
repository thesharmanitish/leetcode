class Solution {
    public int lengthOfLIS(int[] graph) {
        
       
		int size = graph.length;
         if(size<2) return size;
		int count[] = new int[size];
		int lastIndex[] = new int[size];
		
		for (int i = 0; i < lastIndex.length; i++) {
			count[i] = 1;
		}
		for (int i = 1; i < graph.length; i++) {
			for (int j = 0; i>j; j++) {
				if(graph[j]<graph[i] && count[j]+1 >= count[i]){
					count[i] = count[j]+1;
					lastIndex[i] = graph[j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + " : ");

			if(max<count[i]) max = count[i];
		}
        return max;
	
    }
}