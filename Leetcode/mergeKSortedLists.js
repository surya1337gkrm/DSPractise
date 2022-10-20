/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
  //return null(or empty ListNode if length is empty)
  if (!lists.length) return null;
  let mergedList = [];

  //create a fn to push values of the linkedlist to the new list..
  //.. where we store all values of the input lists [ unsorted]
  const fn = (l) => {
    while (l !== null) {
      mergedList.push(l.val);
      l = l.next;
    }
  };

  lists.forEach((list) => {
    //call fn with each list only if its not an empty ListNode
    if (list !== null) fn(list);
  });

  //sort the margedList
  mergedList.sort((a, b) => a - b);

  let resNode = new ListNode();
  let result = resNode;

  //check if mergedList isnt empty and iterate..
  //.. and if empty return null(or empty ListNode)
  if (mergedList.length) {
    mergedList.forEach((el, i) => {
      result.val = el;
      result.next = new ListNode();
      if (i !== mergedList.length - 1) result = result.next;
      else result.next = null;
    });
    return resNode;
  } else return null;
};
