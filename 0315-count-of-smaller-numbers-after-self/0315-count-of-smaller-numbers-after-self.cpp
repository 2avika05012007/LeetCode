class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0);
        vector<int> indexes(n);
        vector<int> temp(n);

        for(int i = 0; i < n; i++){
            indexes[i] = i;
        }
        mergeSort(nums, indexes, temp, ans, 0, n - 1);
        return ans;
    }

    void mergeSort(vector<int>& nums, vector<int>& indexes, vector<int>& temp, vector<int>& ans, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/ 2;
        mergeSort(nums, indexes, temp, ans, left, mid);
        mergeSort(nums, indexes, temp, ans, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;
        int s = 0;

        while(i <= mid && j <= right){
            if(nums[indexes[j]] < nums[indexes[i]]){
                temp[k++] = indexes[j++];
                s++;
            }
            else{
                ans[indexes[i]] += s;
                temp[k] = indexes[i];
                k++;
                i++;
            }
        }
        while(i <= mid){
            ans[indexes[i]] += s;
            temp[k] = indexes[i];
            k++;
            i++;
        }

        while(j <= right){
            temp[k] = indexes[j];
            k++;
            j++;
        }

        for(int t = left; t <= right; t++){
            indexes[t] = temp[t];
        }
    }
};
