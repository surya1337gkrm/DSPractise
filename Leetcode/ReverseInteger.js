/**
 * @param {number} x
 * @return {number}
 */
const revNum = (x) => {
  const rev = +x.toString().split('').reverse().join('');
  if (rev >= -Math.pow(2, 31) && rev <= Math.pow(2, 31) - 1) return rev;
  return 0;
};

var reverse = function (x) {
  if (x < 0) {
    return -revNum(-x);
  } else {
    return revNum(x);
  }
};
