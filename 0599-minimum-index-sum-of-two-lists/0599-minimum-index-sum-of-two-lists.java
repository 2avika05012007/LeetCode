class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<list1.length; i++){
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        String[] ans = new String[list1.length];
        int j = 0;
        for (int i = 0; i < list2.length; i++) {
            String a = list2[i];
            if(map.containsKey(a)){
                int sum = i + map.get(a);
                if (sum < min) {
                    min = sum;
                    j = 0;          
                    ans[j++] = a;
        }
        else if(sum == min){
            ans[j++] = a;
        }
    }
}
return Arrays.copyOf(ans, j);
    }
}