class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        List<String> ll = new LinkedList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i].equals("..")){
                if(!ll.isEmpty())
                    ll.remove(ll.size()-1);
            }else if(arr[i].equals("") || arr[i].equals(".")){
                continue;
            }
            else
                ll.add(arr[i]);

        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<ll.size();i++){  
            result.append('/').append(ll.get(i));
        }
        // result.setLength(result.length()-1);
        return result.length() ==0 ? "/" : result.toString();
    }
}