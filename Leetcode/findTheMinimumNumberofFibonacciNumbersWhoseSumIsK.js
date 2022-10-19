/**
 * @param {number} k
 * @return {number}
 */
var findMinFibonacciNumbers = function (k) {
  //as per question,fib series starts with 1,1...
  //initialize a list with 1,1 as first 2 fib nums
  fib = [1, 1];
  //calculate fib nums until fib num <=k
  let i = 2;
  while (fib[i - 1] + fib[i - 2] <= k) {
    fib.push(fib[i - 1] + fib[i - 2]);
    i++;
  }

  //now we got the fib list which has nums <=k
  //now we need to calculate the sum of any number of fib nums===k
  let res = [];
  let sum = 0;
  //last element of the fib nums list
  let j = fib.length - 1;
  //iterate until sum<=k and j>=0
  let total;
  while (sum <= k && j >= 0) {
    total = sum + fib[j];
    if (total <= k) {
      //if total<=k, then update sum to total value and then push that fib num to res list.
      sum = total;
      res.push(fib[j]);
      if (sum === k) break;
    }
    j--;
  }
  return res.length;
};
