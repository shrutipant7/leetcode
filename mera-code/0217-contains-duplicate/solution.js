/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    let map = {};
    for(let i = 0; i < nums.length; i++) {
        if(map[nums[i]] !== undefined) {
          return true;
        } else {
            map[nums[i]] = nums[i];
        }
    }
    return false;
};
