class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int st = 0;
        int en = m * n - 1;

        while(st<=en){
            int mid = (st+en)/2;
            int r = mid/n;
            int c = mid%n;

            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] < target){
                st = mid+1;
            }
            else{
                en = mid-1;
            }
        }
        return false;
    }
};