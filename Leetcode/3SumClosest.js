/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
//Approach 01 : BruteForce Method
//As we are using same list, Memory Complexity will be O(1), Time Complexity will be O(n^3)
// var threeSumClosest = function (nums, target) {
//   let sum = Math.min(); //Math.min() gives Infinity.
//   for (let i = 0; i < nums.length - 2; i++) {
//     for (let j = i + 1; j < nums.length - 1; j++) {
//       for (let k = j + 1; k < nums.length; k++) {
//         if (
//           Math.abs(target - (nums[i] + nums[j] + nums[k])) <
//           Math.abs(target - sum)
//         ) {
//           sum = nums[i] + nums[j] + nums[k];
//         }
//       }
//     }
//   }
//   return sum;
// };

//Method 02 - Using Sliding window Approach
var threeSumClosest = function (nums, target) {
  //initiate the max sum to Infinity
  let sum = Math.min();
  //sort the array
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length - 2; i++) {
    //initiate left and right indices for sliding window
    let left = i + 1,
      right = nums.length - 1;
    while (left < right) {
      let total = nums[i] + nums[left] + nums[right];
      //compare the total of 3 nums with the oreviously updated sum value
      if (Math.abs(target - total) < Math.abs(target - sum)) sum = total;

      //update the sliding window : left & right.
      if (total < target) left++;
      else right--;
    }
  }
  return sum;
};
