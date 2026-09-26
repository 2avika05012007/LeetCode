class Solution {
public:
    void merge(vector<int>& nums, vector<int>& temp,
               int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            }
            else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        for (int x = start; x <= end; x++) {
            nums[x] = temp[x];
        }
    }

    void mergeSort(vector<int>& nums, vector<int>& temp,
                   int start, int end) {

        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);

        
        if (nums[mid] <= nums[mid + 1])
            return;

        merge(nums, temp, start, mid, end);
    }

    vector<int> sortArray(vector<int>& nums) {

        vector<int> temp(nums.size());

        mergeSort(nums, temp, 0, nums.size() - 1);

        return nums;
    }
};