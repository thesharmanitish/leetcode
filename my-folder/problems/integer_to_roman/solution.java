class Solution {
    static String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    
    public static String intToRoman(int num){
        if (num < 1 || num > 3999) return "";

        StringBuilder result = new StringBuilder();


        
        TreeMap<Integer, String> map = new TreeMap<>();
        for(int i=0;i<roman.length;i++){
            map.put(values[i], roman[i]);
        }

        int i = 0;
                //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num >0) {
            int k = map.floorKey(num);
            num -= k;
            result.append(map.get(k));
        }
        return result.toString();
}
}