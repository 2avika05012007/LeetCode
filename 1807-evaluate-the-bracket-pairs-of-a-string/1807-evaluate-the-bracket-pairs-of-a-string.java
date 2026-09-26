class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                String value = s.substring(i+1 , j);
                if(map.containsKey(value)){
                    ans.append(map.get(value));
                }
                else{
                    ans.append('?');
                }
                i = j;

            }
            else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}