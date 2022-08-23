/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLongestSubstring = function(s) {
    if(!s.length) return 0
    
    let res=''
    let arr=[]
    const stringArr=s.split('')
    
    stringArr.forEach((ele,i)=>{
        if(!res.includes(ele)){
            res+=ele
            arr.push(res.length)
        }
        else{
            res+=ele
            let index=res.split('').findIndex(e=>ele===e)
            res=res.split('').slice(index+1,).join('')
            arr.push(res.length)
        }
    })
    return Math.max(...arr)
};