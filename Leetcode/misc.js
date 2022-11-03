//by default map array method will take a callback with three args : current value,currentIndex and the array
//.map((el,idx,arr)=>{})
//so if we pass less arguments than expected, other variable will be undefined
// and, if we pass extra arguments those will be ignored but will be stored in arguments object ( if using function keyword to define the function)

//parseInt will take 2 arguments : first - value and second- radix value
//if radix value is falsy then default radix will be 10.

//[1,7,11].map(parseInt) returns [1,NaN,3] :
// as in first iteration parseInt(1,0) : radix is falsy so defaults to 10 and parseInt(1,10) is 1
// as in second iteration parseInt(7,1) : radix is 1 whcih didnt exist and parseInt(7,1) returns NaN
// as in third iteration parseInt(11,2) : radix is 2 and parseInt(11,2) is 3
//simillarly [1,7,11].map(console.log) prints el,index and the array

//------------------------------------------//

//function declaration using function keyword
//function expression : using arrow functions or creating a funnction[anonymous fn] and assigning to a variable

//function declaration
function sample() {}

//function expression
const fn1 = function () {};
const fn2 = () => {};
