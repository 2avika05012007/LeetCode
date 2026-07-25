class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(left<=right){
            if(people[left]+people[right]<=limit){
                boat++;
                left++;
                right--;
            }
            else if(people[right]<=limit){
                right--;
                boat++;
            }
            else{
                left++;
            }
            
        }
        return boat;
    }
}