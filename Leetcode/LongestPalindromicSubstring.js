/**
 * @param {string} s
 * @return {string}
 */
//approach 01
var longestPalindrome = function (s) {
  let res = '';
  let maxLen = 0;
  //return the string if it's length<0 or if the input string is a palindrome
  if (s.length < 2 || s === s.split('').reverse().join('')) return s;

  for (let i = 0; i < s.length; i++) {
    let left = i,
      right = i;
    while (s[left] === s[right] && left >= 0 && right < s.length) {
      if (right - left + 1 > maxLen) {
        res = s.slice(left, right + 1);
        maxLen = res.length;
      }
      left--;
      right++;
    }
    (left = i), (right = i + 1);
    while (s[left] === s[right] && left >= 0 && right < s.length) {
      if (right - left + 1 > maxLen) {
        res = s.slice(left, right + 1);
        maxLen = res.length;
      }
      left--;
      right++;
    }
  }
  return res;
};

//approach 02
/**
 * @param {string} s
 * @return {string}
 */

const checkPalindrome = (s, left, right) => {
  while (s[left] === s[right] && left >= 0 && right < s.length) {
    left--;
    right++;
  }
  // when any of those conditions failed, we need to take the substring
  // when the conditions were satisfied i.e,
  // when left isn't decremented and right isn't incremented.
  // so, increment left and in slice,right vlaue will be considered unitl right-1 value

  return s.slice(left + 1, right);
};

var longestPalindrome = function (s) {
  if (s.length < 2 || s.split('').reverse().join('') === s) return s;
  let res1 = '',
    res2 = '',
    res = '';
  for (let i = 0; i < s.length - 1; i++) {
    res1 = checkPalindrome(s, i, i);
    res2 = checkPalindrome(s, i, i + 1);

    let maxLenStr = res1.length > res2.length ? res1 : res2;
    if (maxLenStr.length > res.length) res = maxLenStr;
  }
  return res;
};
