class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[arr1.length];
        int index = 0;

        for (int num : arr2) {

            int count = map.get(num);

            while (count > 0) {
                ans[index] = num;
                index++;
                count--;
            }

            map.remove(num);
        }

        ArrayList<Integer> remaining = new ArrayList<>();

        for (int num : map.keySet()) {
            int count = map.get(num);

            while (count > 0) {
                remaining.add(num);
                count--;
            }
        }

        Collections.sort(remaining);

        for (int num : remaining) {
            ans[index] = num;
            index++;
        }

        return ans;
    }
}