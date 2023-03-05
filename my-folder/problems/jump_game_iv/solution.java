class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.computeIfAbsent(arr[i], v-> new ArrayList<>()).add(i);
        }

        queue.add(0);

        int count = 0;
        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){

                int ind = queue.poll();

                if(ind == arr.length-1)
                    return count;

                if(map.containsKey(arr[ind])){
                    for(int v:map.get(arr[ind])){
                        if(ind!=v ){
                            if(v == arr.length-1) return count+1;
                            queue.add(v);
                        }
                    }
                }
                if(ind>0 && map.containsKey(arr[ind - 1])){
                    queue.add(ind-1);

                }
                
                if(ind<arr.length-1 && map.containsKey(arr[ind + 1])){
                    if(ind+1 == arr.length-1)
                        return count+1;
                    queue.add(ind+1);

                }
                map.remove(arr[ind]);
            }

            count++;
        }
        return -1;
    }
}