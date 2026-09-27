class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            String key = str;
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String f = new String(c);

            if (!map.containsKey(f)) {
                map.put(f, new ArrayList<>());
            }

             map.get(f).add(str);
        }
        return  new ArrayList<>(map.values());
    }
}