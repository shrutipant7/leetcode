/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let maps = new Map();
    for (let i=0; i < s.length; i++){
        if(maps.get(s[i]) != undefined){
           maps.set(s[i], {location: maps.get(s[i]).location, ocurred: maps.get(s[i]).ocurred+1});
        } else {
           maps.set(s[i], {location: i, ocurred: 1});
        }
    }
    
    let max = -1;
    let looped = 0;
    maps.forEach((k, v) => {
      console.log(k.ocurred == 1)
      if(k.ocurred == 1 && !looped){
        looped++;
        max = k.location;
      }
    });
    return max;
};
