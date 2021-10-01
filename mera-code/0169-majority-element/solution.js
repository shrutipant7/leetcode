var majorityElement = function(nums) {
  let maps = new Map();
  let val = -1;
  let len = Math.floor(nums.length/2);
    for(let i=0; i< nums.length; i++) {
        if(maps.get(nums[i]) != undefined){
             maps.set(nums[i], maps.get(nums[i])+1);
           } else {
            maps.set(nums[i], 1);
           }
    }
    maps.forEach((v, k) => {
      if (v > len && v > val) {
        val=k
      }
    })
    return val;
};
