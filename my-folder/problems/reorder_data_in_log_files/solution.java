class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1,s2)->{
                                int idx1 = s1.indexOf(' ');
                                int idx2 = s2.indexOf(' ');
                                String o1 = s1.substring(idx1 + 1);
                                String o2 = s2.substring(idx2 + 1);  
            
                                if(o1.charAt(0)<='9'){
                                    if(o2.charAt(0)<='9'){
                                        return 0;
                                    }
                                        return 1;
                                }
                                else{ 
                                    
                                    if(o2.charAt(0)<='9' )
                                        return -1; //return -1;
                                    else{
                                        int cmpContent = o1.compareTo(o2);
                                        if (cmpContent != 0) 
                                            return cmpContent;
                                    return s1.substring(0,idx1).compareTo(s2.substring(0,idx2));
                                    }
                                 }   
                                    });
        return logs;
    }
}