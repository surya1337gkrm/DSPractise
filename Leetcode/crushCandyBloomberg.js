//Method 01 : Iterative method

// const crushCandy = (str) => {
//   let todo = true;
//   while (todo) {
//     let arr = str.split('');
//     todo = false;
//     for (let i = 0; i < arr.length; i++) {
//       let cur = arr[i];
//       let next = arr[i + 1];
//       let nexNex = arr[i + 2];
//       if (next === undefined) break;

//       if (cur === next && next === nexNex) {
//         todo = true;
//         arr[i] = '-' + arr[i];
//         arr[i + 1] = '-' + arr[i + 1];
//         arr[i + 2] = '-' + arr[i + 2];
//       }
//     }
//     let trimmed = [];
//     for (let i = 0; i < arr.length; i++) {
//       if (arr[i][0] === '-') continue;
//       else trimmed.push(arr[i]);
//     }
//     str = trimmed.join('');
//     console.log(str)
//   }

//   return str;
// };

// console.log(crushCandy('baaabbccddeeedcba'));

//method02 - Using Stack

const candyCrush = (str) => {
  //checking if the input is a string
  if (typeof str !== 'string') return '';
  //returning the input string if it's length is less than 3.
  if (str.length < 3) return str;

  //initiate a stack
  const stack = [];
  for (let [i, char] of str.split('').entries()) {
    //in stack, add a list for each element which consists the character and the occurence count
    //[char,occurenceCount]
    const lastStackEl = stack[stack.length - 1];
    //if stack length is not zero and last element in the stack is equal to char then increse the count
    if (stack.length && lastStackEl[0] === char) {
      lastStackEl[1] += 1;
      //pop the last element in the stack if count >=3
      if (lastStackEl[1] >= 3) {
        //and also check if the next element is same after 3 count and if not, pop
        if (char === str[i + 1]) lastStackEl[1] += 1;
        else stack.pop();
      }
    } else stack.push([char, 1]);
  }
  str = '';
  for (let [el, count] of stack) {
    //add char to empty string count times using .repeat() method
    str += el.repeat(count);
  }
  return str;
};
console.log(candyCrush('baaaabbccddeeedcba'));
