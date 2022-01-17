class Solution {
    public String toGoatLatin(String sentence) {
        
        String[] str = sentence.split(" ");
        int count = 0;
        StringBuilder out = new StringBuilder();
        for(String s:str){
            if(s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u") || s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U")){
                
                s = s.concat("ma");
            }else{
                
                s = s.substring(1) + s.charAt(0) + "ma";
                
            }
            count++;
            out.append(s);
            for(int i=0;i<count;i++)
                out.append("a");
            out.append(" ");
        }
        
        return out.substring(0,out.length()-1).toString();
    }
}