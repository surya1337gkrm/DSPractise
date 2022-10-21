/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
//using iterative method: Using pointers
var reverseList = function (head) {
  //return if head or head.next is null (i.e, null ListNode or ListNode with single element)
  if (!head || !head.next) return head;

  //initiate pointers to store current node, previous node and next node
  //previous points to null whereas curr will take head(or starting node)
  let prev = null;
  let curr = head;
  let next = null;
  //iterate until current node becomes null
  while (curr !== null) {
    //store next node in a temp variable so that we can use later.
    next = curr.next;
    //create a backwards connection i.e, instead of pointing to the next element, point to previous element
    curr.next = prev;
    //shift previous pointer to the next element
    prev = curr;
    //shift current pointer to the next element (we stored in temp)
    curr = next;
  }
  return prev;
};
