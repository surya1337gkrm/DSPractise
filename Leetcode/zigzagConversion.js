/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows === 1) return s;

  const obj = {};
  let direction = 1;
  let count = 0;
  let i = 0;

  while (count < s.length) {
    if (obj[i] === undefined) {
      obj[i] = s[count];
    } else {
      obj[i] += s[count];
    }
    if (i === 0) {
      direction = 1;
      i += direction;
    } else if (i > 0 && i < numRows - 1) {
      i += direction;
    } else if (i === numRows - 1) {
      direction = -1;
      i += direction;
    }
    count++;
  }
  return Object.values(obj).join('');
};
