/**
 * @param {string[]} strs
 * @return {string}
 */
//Bruteforce Approach
// var longestCommonPrefix = function(strs) {
//     let res=""
//     let firstWord=strs[0]
//     for(let i=0;i<firstWord.length;i++){
//         for(let j=1;j<strs.length;j++){
//             if(firstWord[i]!==strs[j][i]) return res
//         }
//         res+=firstWord[i]
//     }
//     return res
// };

//Better Approach
var longestCommonPrefix = function (strs) {
  let res = '',
    i = 0;
  strs.sort();
  let minLen = Math.min(...strs.map((el) => el.length));
  while (i < minLen && strs[0][i] === strs[strs.length - 1][i]) {
    res += strs[0][i];
    i++;
  }
  return res;
};
