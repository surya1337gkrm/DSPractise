/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  if (nums.length < 3) return [];
  //sorting the numbers
  nums.sort((a, b) => a - b);
  const res = [];

  for (let i = 0; i < nums.length; i++) {
    //if the num is >0, break and also check for duplicates
    if (nums[i] > 0) break;
    //check for duplicates, and if found skip the number
    if (i > 0 && nums[i - 1] === nums[i]) continue;

    //initiating 2 pointers, simillar to sliding window problem
    let l = i + 1;
    let r = nums.length - 1;

    while (l < r) {
      let sum = nums[i] + nums[l] + nums[r];
      if (sum === 0) {
        res.push([nums[i], nums[l], nums[r]]);
        //and then, increment left and decrement right
        l++;
        r--;
        //check if upon sliding, if there are any possible duplicates
        while (l < r && nums[l - 1] === nums[l]) l++;
      } else if (sum < 0) l++;
      else r--;
    }
  }
  return res;
};

//Method 02
// var threeSum = (nums) => {
//   nums.sort((a, b) => a - b);
//   let result = [];

//   for (let i = 0; i < nums.length - 2; i++) {
//     if (nums[i] > 0) break;
//     if (i > 0 && nums[i] === nums[i - 1]) {
//       continue;
//     }

//     let j = i + 1;
//     let k = nums.length - 1;

//     while (j < k) {
//       let sum = nums[i] + nums[j] + nums[k];
//       if (sum < 0) {
//         j++;
//       } else if (sum > 0) {
//         k--;
//       } else {
//         result.push([nums[i], nums[j], nums[k]]);
//         while (j < k && nums[j] === nums[j + 1]) {
//           j++;
//         }
//         while (j < k && nums[k] === nums[k - 1]) {
//           k--;
//         }
//         j++;
//         k--;
//       }
//     }
//   }
//   return result;
// };
