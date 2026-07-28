class Solution {
    public boolean fun(int a){
        int n = a;
        while(a!=0){
            int b = a%10;
            if(b == 0){
                return false;
            }
            if(n%b != 0){
                return false;
            }
            a/=10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i<right+1; i++){
            if(fun(i)){
                list.add(i);
            }
        }
        return list;
    }
}