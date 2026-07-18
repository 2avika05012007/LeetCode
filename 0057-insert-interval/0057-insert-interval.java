class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] news = newInterval;
        for(int[] current: intervals){
            if(current[1]<news[0]){
                ans.add(current);
            }
            else if(current[0]>news[1]){
                ans.add(news);
                news = current;
            }
            else{
                news[0] = Math.min(news[0], current[0]);
                news[1] = Math.max(news[1], current[1]);
            }
        }
        ans.add(news);
        return ans.toArray(new int[ans.size()][]);
    }
}