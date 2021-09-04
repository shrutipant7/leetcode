/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  let maps = new Map();
    for(let i=0; i< s.length; i++) {
        if(maps.get(s[i]) != undefined){
            maps.set(s[i], maps.get(s[i])+1);
        } else {
           maps.set(s[i], 1);
        }
    }
    for(let i=0; i< t.length; i++) {
        if(maps.get(t[i]) != undefined){
           if(maps.get(t[i]) === 1){
             maps.delete(t[i]);
           } else {
            maps.set(t[i], maps.get(t[i])-1);
           }
        } else {
          //New character present in
           return false;
        }
    }
    if(maps.size > 0) {
      return false
    } else {
      return true
    };
};
