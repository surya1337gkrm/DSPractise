/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
 var convert = function(s, numRows) {
    if(numRows===1) return s
    
    const obj={}
    let direction=1 // down and -1 for upwards direction
    let count=0
    let i=0
    
    
    while(count<s.length){
        //check if the object has the key
        if(obj[i]===undefined){
            obj[i]=s[count]
        }else{
            obj[i]+=s[count]
        }
        if(i===0){ 
            //for top element , traversal direction should be down
            direction=1
            i+=direction
        }
        else if(i>0 && i<numRows-1){
            //for middle elements, continue the direction 
            i+=direction
        }
        else if(i===numRows-1){
           //for last element, flip the direction
            direction=-1
            i+=direction
        }
       count++ 
    }
    
    return Object.values(obj).join('')
};
