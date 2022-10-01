const arr = [1, 34, 22, 0, 0, 99, 9, 0, 2, 3];
const pushZeroesToEnd = (arr) => {
  let count = 0;
  arr.forEach((el, idx) => {
    if (el !== 0) {
      arr[count] = el;
      count++;
    }
  });
  while (count < arr.length) {
    arr[count] = 0;
    count++;
  }
};

pushZeroesToEnd(arr);
console.log(arr);
