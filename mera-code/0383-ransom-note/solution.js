/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
      let maps = new Map();
    for(let i=0; i< magazine.length; i++) {
        if(maps.get(magazine[i]) != undefined){
            maps.set(magazine[i], maps.get(magazine[i])+1);
        } else {
           maps.set(magazine[i], 1);
        }
    }
    console.log(maps)
    for(let i=0; i< ransomNote.length; i++) {
        if(maps.get(ransomNote[i]) != undefined){
           if(maps.get(ransomNote[i]) === 1){
             maps.delete(ransomNote[i]);
           } else {
            maps.set(ransomNote[i], maps.get(ransomNote[i])-1);
           }
        } else {
          //New character present in ransomNote
           return false;
        }
    }
      return true
};
