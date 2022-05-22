class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Map<Integer, Integer> map = new TreeMap<>();
        int i=0;
        for(int j=0;j<capacity.length;j++){
            int diff = capacity[j]-rocks[j];
            map.put(j, diff);
        }
      Map<Integer, Integer> sortedMap = map.entrySet().stream()
                               .sorted(Map.Entry.comparingByValue())
                               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                               (e1, e2) -> e2, LinkedHashMap::new));

        for(Map.Entry<Integer, Integer> p:sortedMap.entrySet()){
            if(p.getValue() > additionalRocks)
                break;
            additionalRocks -= p.getValue();
            if(additionalRocks<0)
                break;
            System.out.println("nitish");
            i++;            
        }
        return i;
    }
}