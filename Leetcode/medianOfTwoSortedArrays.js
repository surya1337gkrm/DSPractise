/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  const list = [...nums1, ...nums2].sort((a, b) => a - b);
  if (list.length % 2 !== 0) return list[Math.floor(list.length / 2)];
  return (list[list.length / 2] + list[list.length / 2 - 1]) / 2;
};
