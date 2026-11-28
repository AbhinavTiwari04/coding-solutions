/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(ListNode temp:lists){
            for(ListNode t=temp;t!=null;t=t.next){
                pq.add(t.val);

            }
        }
        ListNode dummy=new ListNode(10);
        ListNode head=new ListNode();
        dummy.next=head;
        while(!pq.isEmpty()){
            head.next=new ListNode(pq.poll());
            head=head.next;
        }
        return dummy.next.next;
    }
}