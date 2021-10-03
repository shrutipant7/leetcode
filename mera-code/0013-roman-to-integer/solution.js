var romanToInt = function(s) {
    let symbolMap = new Map ();
    symbolMap.set("I", 1);
    symbolMap.set("V", 5);
    symbolMap.set("X", 10);
    symbolMap.set("L", 50);
    symbolMap.set("C", 100);
    symbolMap.set("D", 500);
    symbolMap.set("M", 1000);
    let exceptionString = ['IV','IX', 'XL', 'XC', 'CD', 'CM'];
    let str = s.split("");
    let sum = 0;
    for(let i=0; i<str.length; i++) {
        //Check if next and current are in reverse order i.e., smaller -> larger
        let symbolPrev = symbolMap.get(str[i]); //gets key value i.e., 1,5,10
        let symbolNext = symbolMap.get(str[i+1]);
        if (symbolPrev !== undefined) {
           if (exceptionString.includes(str[i].concat(str[i+1]))){
                sum = sum + (symbolNext-symbolPrev);
                ++i;
            } else {
                sum += symbolPrev;
            }
        }
    }
        return sum;
};
