/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const res = {};
  for (let i = 0; i < nums.length; i++) {
    if (res[nums[i]] === undefined) {
      res[target - nums[i]] = i;
    } else {
      return [res[nums[i]], i];
    }
  }
};

//method2 : using es6

let twoSum = (nums, target) => {
  const res = {};
  let sol;
  nums.forEach((num, i) => {
    if (res[num] === undefined) res[target - num] = i;
    else sol = [res[num], i];
  });
  return sol;
};
