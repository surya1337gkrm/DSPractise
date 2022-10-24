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

//using recursion
// var reverseList = function (head) {
//   if (!head || !head.next) return head;

//   let newHead = reverseList(head.next);
//   head.next.next = head;
//   head.next = null;
//   return newHead;
// };

//recursive method: 02
//  var reverseList = function(head) {
//   let prev=null
//   let next=null
//   const revList=(head,prev)=>{
//       if(!head) return prev
//       next=head.next
//       head.next=prev
//       return revList(next,head)
//   }
//   return revList(head,prev)
// };

//recursive method:03 (passing prev as default param to the function)
// let next;
// var reverseList = function (head, prev = null) {
//   // if head is null, return prev(as,tail will become new head at the end.)
//   if (!head) return prev;
//   //store head.next in a temp variable to access later. because, next will become the head in next iteration
//   next = head.next;
//   //point head.next to the previous value.
//   head.next = prev;
//   //call reverseList function in recursion with new head and its previous value(which will be stored in head.)
//   return reverseList(next, head);
// };

/*Working flow(recursion method 03)
input : 1->2->3->null
1st Iteration:
  prev=null
  next=2->3->null
  head.next=null //head:null<-1
  reverseList(2->3->null,null<-1)
2nd Iteration:
  prev=null<-1
  next=3->null
  head.next=null<-1 //head:null<-1<-2
  reverseList(3->null,null<-1<-2)
3rd Iteration:
  prev=null<-1<-2
  next=null
  head.next=null<-1<-2 //head:null<-1<-2<-3
  reverseList(null,null<-1<-2<-3)
4th Iteration:
  as head is null, returns prev which is null<-1<-2<-3 which is reversed linkedlist*/
