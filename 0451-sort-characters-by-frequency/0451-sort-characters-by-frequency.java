class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        if(s.length() == 1){
            return s;
        }
        for(char i: s.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            while (freq> 0) {
                ans.append(ch);
                freq--;
            }
        }
        return ans.toString();
    }
}