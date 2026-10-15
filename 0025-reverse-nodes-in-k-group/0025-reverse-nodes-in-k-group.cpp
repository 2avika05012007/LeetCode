/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr || k == 1) {
            return head;
        }

        ListNode dummy(0);
        dummy.next = head;
        ListNode* p = &dummy;

        while(true){
            ListNode* kth = p;

            for(int i = 0; i < k && kth != nullptr; i++){
                kth = kth->next;
            }

            if(kth == nullptr){
                break;
            } 
            
            ListNode* nextGroup = kth->next;
            ListNode* prev = nextGroup;
            ListNode* curr = p->next;
            while(curr != nextGroup){
                ListNode* next = curr->next;
                curr->next = prev;
                prev = curr;
                curr = next;
            }
            ListNode* o = p->next;
            p->next = kth;
            p = o;
        }

        return dummy.next;
    }
};
