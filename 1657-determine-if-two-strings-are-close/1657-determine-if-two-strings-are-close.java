class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i<word1.length(); i++){
            char a = word1.charAt(i);
            map1.put(a,map1.getOrDefault(a,0)+1);
        }
        for(int i = 0; i<word2.length(); i++){
            char a = word2.charAt(i);
            map2.put(a,map2.getOrDefault(a,0)+1);
        }
        ArrayList<Integer> list1= new ArrayList<>();
        ArrayList<Integer> list2= new ArrayList<>();
        for(int i: map1.values()){
            list1.add(i);
        }
        for(int i: map2.values()){
            list2.add(i);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
            }
        Collections.sort(list1);
        Collections.sort(list2);
        if(list1.equals(list2)){
            return true;
        }
        return false;
    }
}