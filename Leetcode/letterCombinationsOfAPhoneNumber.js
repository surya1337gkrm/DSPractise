/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  //return empty list if input is empty string
  if (!digits.length) return [];
  const mapDigits = {
    2: 'abc',
    3: 'def',
    4: 'ghi',
    5: 'jkl',
    6: 'mno',
    7: 'pqrs',
    8: 'tuv',
    9: 'wxyz',
  };
  let res = [];

  //recursive function
  const fn = (idx, str) => {
    if (idx === digits.length) {
      res.push(str);
      return;
    }

    //get the letters for each digit
    let letters = mapDigits[digits[idx]];
    //for each letter, increase the index and concate the letter to the previous string
    for (let i = 0; i < letters.length; i++) {
      fn(idx + 1, str + letters[i]);
    }
  };

  //calling recursive function with starting index(0) and an empty string.
  fn(0, '');
  return res;
};

/*Working Explaination:
lets say input digits -> '23'

when we call, fn(0,''):
    step01: letters=mapDigits[digits[0]]=mapDigits[2]='abc'
            fn(1,'a')
            fn(1,'b')
            fn(1,'c')
    step02: 
            fn(1,'a')->letters=mapDigits[digits[1]]=mapDigits[2]='def'->fn(2,'ad')
                                                                        fn(2,'ae')
                                                                        fn(2,'af')
            fn(1,'b')->letters=mapDigits[digits[1]]=mapDigits[2]='def'->fn(2,'bd')
                                                                        fn(2,'be')
                                                                        fn(2,'bf')
            fn(1,'c')->letters=mapDigits[digits[1]]=mapDigits[2]='def'->fn(2,'cd')
                                                                        fn(2,'ce')
                                                                        fn(2,'cf')
    step03: fn(2,str) -> index(2)===digits.length(which is 2) push the strings to res List.*/
