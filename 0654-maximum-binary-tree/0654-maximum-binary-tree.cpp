/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        if(nums.empty()){
            return nullptr;
        }
        int m = 0;
        for(int i = 1; i<nums.size(); i++){
            if(nums[i]>nums[m]){
                m = i;
            }
        }
        TreeNode* r = new TreeNode(nums[m]);
        vector<int> left(nums.begin(), nums.begin() + m);
        vector<int> right(nums.begin()+m+1, nums.end());
        r->left = constructMaximumBinaryTree(left);
        r->right = constructMaximumBinaryTree(right);
        return r;
    }
};