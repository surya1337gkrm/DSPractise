/**
 * @param {number[]} height
 * @return {number}
 */

//O(n^2) Approach
// var maxArea = function(height) {
//     let max=0
//     let a,b
//     for(let i=0;i<height.length;i++){
//         for(let j=1;j<height.length;j++){
//            a=Math.min(height[i],height[j])
//            b= j-i
//            let res=a*b
//            if(res>max) max=res
//         }
//     }
//     return max
// };

var maxArea = function (height) {
  let max = 0;
  let left = 0,
    right = height.length - 1,
    area;
  while (left < right) {
    //calculating the area
    //min of two heights will the height of the container
    //diff btwn indices will be the width

    area = Math.min(height[left], height[right]) * (right - left);
    max = max < area ? area : max;
    height[left] < height[right] ? left++ : right--;
  }
  return max;
};
