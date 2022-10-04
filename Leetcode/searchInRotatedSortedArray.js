/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;
  while (left <= right) {
    let midIdx = Math.floor((left + right) / 2);
    if (nums[midIdx] === target) return midIdx;
    if (nums[left] <= nums[midIdx]) {
      //left side is sorted
      if (nums[left] <= target && target <= nums[midIdx]) {
        right = midIdx - 1;
      } else left = midIdx + 1;
    } else {
      //right side is sorted
      if (nums[midIdx] <= target && target <= nums[right]) {
        left = midIdx + 1;
      } else right = midIdx - 1;
    }
  }
  return -1;
};
