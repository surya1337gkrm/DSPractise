/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

//approach 01 : BRUTEFORCE
// var reverseKGroup = function (head, k) {
//   let l = [];
//   //convert the linkedlist to a list
//   while (head !== null) {
//     l.push(head.val);
//     head = head.next;
//   }
//   let start = 0;
//   let arrT = [];
//   //start from 0 and check upto k'th element from start
//   //slice that sub array and reverse the subarray and join the reversed elements.
//   while (start + k <= l.length) {
//     let subArr = l.slice(start, start + k);
//     arrT = [...arrT, ...subArr.reverse()];
//     start += k;
//   }
//   //join the remaining elements
//   arrT = [...arrT, ...l.slice(start)];
//   let resNode = new ListNode();
//   let result = resNode;

//   //construct the linkedlist
//   arrT.forEach((el, i) => {
//     result.val = el;
//     result.next = new ListNode();
//     if (i !== arrT.length - 1) result = result.next;
//     else result.next = null;
//   });

//   return resNode;
// };

//APPROACH 02 : NLOGN
var reverseKGroup = function (head, k) {
  if (!head || k === 1) return head;
  let dummy = new ListNode(0, head);
  let curr = head;
  let prev = dummy;
  let next = null;
  let len = 0;
  while (curr) {
    curr = curr.next;
    len++;
  }
  while (len >= k) {
    curr = prev.next;
    next = curr.next;
    for (let i = 1; i < k; i++) {
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
      next = curr.next;
    }
    prev = curr;
    len -= k;
  }
  return dummy.next;
};
