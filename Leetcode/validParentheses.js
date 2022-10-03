/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const match = {
    '(': ')',
    '[': ']',
    '{': '}',
  };
  let stack = [];
  for (let i = 0; i < s.length; i++) {
    let el = s[i];
    let lastEle = stack[stack.length - 1];
    if (match[el]) {
      stack.push(match[el]);
    } else if (lastEle === el) stack.pop();
    else return false;
  }
  return stack.length === 0;
};
