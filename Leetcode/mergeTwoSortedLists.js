/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
const linkedListToArray = (list, arr) => {
  while (list) {
    arr.push(list.val);
    list = list.next;
  }
};
var mergeTwoLists = function (list1, list2) {
  if (list1 === null) return list2;
  if (list2 === null) return list1;

  let l1 = [],
    l2 = [];

  linkedListToArray(list1, l1);
  linkedListToArray(list2, l2);

  const res = [...l1, ...l2].sort((a, b) => a - b);
  const resNode = new ListNode();
  let result = resNode;
  res.forEach((el, i) => {
    result.val = el;
    result.next = new ListNode();
    if (i !== res.length - 1) {
      result = result.next;
    } else {
      result.next = null;
    }
  });
  return resNode;
};
