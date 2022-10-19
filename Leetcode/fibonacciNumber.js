/**
 * @param {number} n
 * @return {number}
 */
var fib = function (n) {
  //method01 : using dp
  if (n < 2) return n;
  //creating a list to store the fib nums
  let fib = new Array(n).fill(0);
  fib[0] = 0;
  fib[1] = 1;
  //calculate the fib nums and store in the list for easy access.
  for (let i = 2; i <= n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }
  return fib[n];

  //method02 : Akra-Bazzi Formula
  // let fibVal=  parseInt((Math.pow((1+Math.sqrt(5))/2,n) - Math.pow((1-Math.sqrt(5))/2,n))/(Math.sqrt(5)))
  // return fibVal
};
