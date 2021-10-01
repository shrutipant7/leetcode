
var singleNumber = function(nums) {
  let maps = new Map();
  let val = 0;
    for(let i=0; i< nums.length; i++) {
        if(maps.get(nums[i]) != undefined){
             maps.delete(nums[i]);
           } else {
            maps.set(nums[i], nums[i]);
           }
    }
    maps.forEach((key, value) => {
      val = value;
    })
    return val;
};
