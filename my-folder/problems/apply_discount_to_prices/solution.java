class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] st = sentence.split(" ");
        int i=0;
        StringBuilder sb = new StringBuilder();
        for(String s:st){
            String temp = s.substring(1);
            if(!s.startsWith("$") ||!temp.matches("[0-9]+")){
                i++;
                sb.append(s+" ");
                continue;
            }
            double sum = 0;
            for(char c:temp.toCharArray()){
                sum = sum*10+c-'0';
            }
            sum = sum - sum*discount/100;
            
            st[i] = "$"+String.format("%.2f", sum);
            sb.append(st[i]+" ");
            i++;
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}