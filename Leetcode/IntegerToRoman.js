/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
  const roman = {
    1: 'I',
    4: 'IV',
    5: 'V',
    9: 'IX',
    10: 'X',
    40: 'XL',
    50: 'L',
    90: 'XC',
    100: 'C',
    400: 'CD',
    500: 'D',
    900: 'CM',
    1000: 'M',
  };
  let res = '';
  let i = 0;
  while (num !== 0) {
    let key = Object.keys(roman).reverse()[i];
    if (num >= key) {
      num -= key;
      res += roman[key];
    } else i++;
  }
  return res;
};
