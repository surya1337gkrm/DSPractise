/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
  str = str.trim();
  str = parseInt(str, 10);
  if (!str) return 0;
  if (str > Math.pow(2, 31) - 1) {
    return Math.pow(2, 31) - 1;
  }
  if (str < Math.pow(-2, 31)) {
    return Math.pow(-2, 31);
  } else {
    return str;
  }
};
