class Solution {
    public boolean checkPerfectNumber(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<num; i++){
            if(num%i == 0){
                list.add(i);
            } 
        }
        int sum = 0;
        for(int i: list){
            sum += i;
        }
        return sum == num;
    }
}