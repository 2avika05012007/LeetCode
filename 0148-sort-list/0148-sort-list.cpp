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
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL){
            return head;
        }
        ListNode* s = head;
        ListNode* f = head;
        ListNode* prev = NULL;

        while(f != NULL && f->next != NULL){
            prev = s;
            s = s->next;
            f = f->next->next;
        }
        prev->next = NULL;
        ListNode* l = sortList(head);
        ListNode* r = sortList(s);

        return merge(l, r);
    }

    ListNode* merge(ListNode* l, ListNode* r) {
        ListNode dummy(0);
        ListNode* tail = &dummy;

        while(l != NULL && r != NULL){
            if (l->val <= r->val) {
                tail->next = l;
                l = l->next;
            }
            else{
                tail->next = r;
                r = r->next;
            }
            tail = tail->next;
        }
        if(l != NULL){
            tail->next = l;
        }
        if(r != NULL){
            tail->next = r;
        }
        return dummy.next;
    }
};

