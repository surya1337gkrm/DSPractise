/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
  const roman = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  };
  let res = 0;
  for (let i = 0; i < s.length; i++) {
    let curr = roman[s[i]];
    let next = roman[s[i + 1]];
    //for out of bound, i+1>=n, roman[s[i+1]] will be undefined
    /*anything < undefined will be false, 
        and false related ternary statement will be executed.*/
    res = curr < next ? res - curr : res + curr;
  }
  return res;
};
