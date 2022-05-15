// const arr1 = ['a', 'b', 'c', 'd', 'x'];
// const arr = new Array(100).fill('a');
// arr[arr.length - 1] = 'z';
// const arr2 = ['x', 'z'];

// const compare = (arr1, arr2) => {
//   // for(let i=0;i<arr1.length;i++){
//   //   if(arr2.includes(arr1[i])) return true
//   // }
//   // return false
//   //approach02
//   // let res
//   // arr2.forEach(item=>{
//   //   res=arr1.includes(item)
//   // })
//   // return res
//   //approach03

//   if (
//     arr1.length > 0 &&
//     arr2.length > 0 &&
//     Array.isArray(arr1) &&
//     Array.isArray(arr2)
//   )
//     return arr1.filter((ele) => arr2.includes(ele)).length > 0;
//   else return false;
// };

// console.log(compare(arr1, arr2));

// const sortArrays = (arr1, arr2) => [...arr1, ...arr2].sort((a, b) => a - b);

// console.log(sortArrays([22, 999, 21, 11], [10, 9, 2]));

// let [first, second] = [
//   [5, 6],
//   [7, 8],
// ];
// second = first.map((item, index) => {
//   return item + second[index];
// });
// console.log(second);

// const arrDuplicate = (arr) => {
//   let count = 0;
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = i + 1; j < arr.length; j++) {
//       if (arr[i] === arr[j]) return arr[i];
//     }
//   }
//   return undefined;
// };

// const arrDuplicate2 = (arr) => {
//   let obj = {};
//   for (let i = 0; i < arr.length; i++) {
//     if (obj[arr[i]]) {
//       return arr[i];
//     } else obj[arr[i]] = 1;
//   }
//   return undefined;
// };
// console.log(arrDuplicate2([2, 5, 5, 2, 1, 2, 1, 3, 2, 1]));

//import module when package.json is available
import {Linkedlist} from './Linkedlist/Linkedlist.js'
import { DoubleLinkedlist } from './Linkedlist/DoubleLinkedlist.js'

//when package.json isnt available
// const Linkedlist=require('./Linkedlist/Linkedlist')
const n=new Linkedlist(10)
// n.append(11)
// n.prepend(9)
// n.insert(1,116)
// n.insert(2,117)
// n.insert(5,118)
// n.remove(3)
// n.remove(5)
// n.remove(4)
// n.remove(3)
// n.remove(0)
// n.remove(0)
// console.log(n.printList())
// console.log(n)

const doubleList=new DoubleLinkedlist(9)
doubleList.append(11)
doubleList.prepend(8)
doubleList.insert(2,10)
doubleList.remove(3)
doubleList.remove(2)
doubleList.remove(0)




console.log(doubleList)
console.log(doubleList.printList())