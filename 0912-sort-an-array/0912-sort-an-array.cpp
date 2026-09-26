class Solution {
public:
    void merge(vector<int>& a, int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int k = 0;
        vector<int> temp(end - start + 1);

        while(i<=mid && j<=end){
            if(a[i]<a[j]){
                temp[k] = a[i];
                i++;
            }
            else{
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k] = a[i];
            i++;
            k++;
        }
        while(j<=end){
            temp[k] = a[j];
            j++;
            k++;
        }
        for (int x = 0; x < temp.size(); x++) {
            a[start + x] = temp[x];
        }

    }
    void mergesort(vector<int>& a, int start, int end){
        if(start<end){
            int mid = start+(end-start)/2;
            mergesort(a, start, mid);
            mergesort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }

    vector<int> sortArray(vector<int>& nums) {
        mergesort(nums, 0, nums.size()-1);
        return nums;
    }
};