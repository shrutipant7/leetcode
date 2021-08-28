/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let targetArray = [];
    for(let i=0; i< nums.length; i++) {
    for(let j=0; j< i; j++) {
        if(nums[i]+nums[j]===target) {
            targetArray.push(i);
            targetArray.push(j);
        }
    }
    }
    return targetArray;
};
