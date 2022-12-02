/**
 * @param {string} text
 * @return {number}
 */

var maxNumberOfBalloons = function (text) {
  const map = {};
  for (let i = 0; i < text.length; i++) {
    map[text[i]] = map[text[i]] + 1 || 1;
  }
  return (
    Math.min(
      map['b'],
      map['a'],
      Math.floor(map['l'] / 2),
      Math.floor(map['o'] / 2),
      map['n']
    ) || 0
  );
};
