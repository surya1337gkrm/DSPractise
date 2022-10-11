/**
 * @param {number} n
 * @return {string[]}
 */
//method 01
// const isValid = (s) => {
//   const match = {
//     '(': ')',
//   };
//   let stack = [];
//   for (let i = 0; i < s.length; i++) {
//     let el = s[i];
//     let lastEle = stack[stack.length - 1];
//     if (match[el]) {
//       stack.push(match[el]);
//     } else if (el === lastEle) stack.pop();
//     else return false;
//   }
//   return stack.length === 0;
// };

// var generateParenthesis = function (n) {
//   let res = [];
//   const genStr = (str, len) => {
//     if (len === 0) {
//       res.push(str);
//       return;
//     }
//     genStr(str + '(', len - 1);
//     genStr(str + ')', len - 1);
//   };
//   genStr('', 2 * n);

//   let result = [];
//   for (let i = 0; i < res.length; i++) {
//     if (isValid(res[i])) {
//       result.push(res[i]);
//     }
//   }
//   return result;
// };

//method02
/**
 * @param {number} n
 * @return {string[]}
 */
let res = [];
const genStr = (str, left, right) => {
  if (left === 0 && right === 0) return res.push(str);
  if (left > right) return;
  if (left > 0) genStr(str + '(', left - 1, right);
  if (right > 0) genStr(str + ')', left, right - 1);
};
var generateParenthesis = function (n) {
  res = [];
  if (n === 1) return ['()'];
  genStr('(', n - 1, n);
  return res;
};
