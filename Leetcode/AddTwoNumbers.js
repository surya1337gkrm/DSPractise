/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let num1 = '';
  let num2 = '';

  while (l1 !== null) {
    num1 += l1.val.toString();
    l1 = l1.next;
  }
  while (l2 !== null) {
    num2 += l2.val.toString();
    l2 = l2.next;
  }
  /*if we use + to typecast to integer it will convert 
    into integer but when the resultant number is too big, 
    it will cause errors, so choose BigInt instead of int*/

  num1 = BigInt(num1.split('').reverse().join(''));
  num2 = BigInt(num2.split('').reverse().join(''));
  let res = (num1 + num2).toString().split('').map(Number);
  res = res.reverse();

  const resNode = new ListNode();
  let result = resNode;

  res.forEach((num, i) => {
    result.val = num;
    result.next = new ListNode();

    if (i !== res.length - 1) {
      //as properties aren't changed, original object properties will not be changes
      // when properties are changes, as it is soft copy, chnages will be reflected in the oroginal object too.

      result = result.next;
    } else {
      result.next = null;
    }
  });

  return resNode;
};
