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
