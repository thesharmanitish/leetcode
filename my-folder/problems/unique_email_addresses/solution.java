import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
     public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();
        
        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e.length(); i++) {
                if (e.charAt(i) == '.') {
                    continue;
                } else if (e.charAt(i) == '+' ) {
                    int idx = e.length() - 1;
                    while (e.charAt(idx) != '@') {
                        idx--;
                    }
                    sb.append(e.substring(idx));
                    break;
                } else if(e.charAt(i) == '@') {
                	sb.append(e.substring(i));
                    break;
                }else {
                    sb.append(e.charAt(i));
                }
            }
            emailsSet.add(sb.toString());
        }
        
        return emailsSet.size();
    }
}
//     public int numUniqueEmails(String[] emails) {
//         int count = 0;
//         Pattern p = Pattern.compile("[a-zA-Z0-9\\.\\+]*@[a-zA-Z0-9\\.\\+]*\\.\\w*$");
//         List<String> res = new java.util.LinkedList<>();
//         String str;
//         for(String s:emails){
//             Matcher m = p.matcher(s);
//             while(m.find()){
//             	String token = m.group();
//             	String local = token.substring(0,token.indexOf("@"));
//             	String domain = token.substring(token.indexOf("@")+1);
//             	local = local.replaceAll("\\.", "");
//             	token = local +"@"+domain;
//                 if(res.isEmpty()) {
                
//                 	res.add(token.replaceAll("(?<=[a-z]*)[\\+][a-zA-Z0-9\\.\\+]*(?=@)", ""));
//                 }
//                 else {
//                 	str = token.replaceAll("(?<=[a-z]*)[\\+][a-zA-Z0-9\\.\\+]*(?=@)", "");
//                 	if(!res.contains(str))
//                 		res.add(str);
//                 }
                
                
//             }
                
//             }
//         // System.out.println(res.size());
//         return res.size();
    
//     }
// }