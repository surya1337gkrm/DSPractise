//in chrome, when there are less than 10 elements, insertion sort will be used.
// when there are more than 10 elements, quicksort will be used.

//using recursion
const arr = [4, 8, 9, 1];
const quickSort = (arr) => {
  if (arr.length <= 1) return arr;
  const left = [];
  const right = [];
  let midIdx = Math.floor(arr.length / 2);
  let pivot = arr.splice(midIdx, 1)[0];
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < pivot) left.push(arr[i]);
    else right.push(arr[i]);
  }
  return [...quickSort(left), pivot, ...quickSort(right)];
};

console.log(quickSort(arr));
