/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = [];
    for(let i=0; i<s.length; i++) {
        if(stack.length > 0 && validatePair(stack[stack.length-1], s.charAt(i)))
            stack.pop();
        else
            stack.push(s.charAt(i));
    }
    return stack.length === 0;
};

function validatePair(c1, c2) {
    if(c1 === '(' && c2 === ')')
        return true;
    else if(c1 === '[' && c2 === ']')
        return true;
    else if(c1 === '{' && c2 === '}')
        return true;
    else 
        return false;
}
