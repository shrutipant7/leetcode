var intToRoman = function(num) {

const conversionArray = [        
    { arabic: 1000, roman: "M"},
    { arabic: 900, roman: "CM"},
    { arabic: 500, roman: "D"},
    { arabic: 400, roman: "CD"},
    { arabic: 100, roman: "C"},
    { arabic: 90, roman: "XC"},
    { arabic: 50, roman: "L"},
    { arabic: 40, roman: "XL"},
    { arabic: 10, roman: "X"},
    { arabic: 9, roman: "IX"},
    { arabic: 5, roman: "V"},
    { arabic: 4, roman: "IV"},
    { arabic: 1, roman: "I"}
];

let resultString = "";

while ( num > 0 ) {
    
	// .find() will search the array in order of highest numeral to lowest
	// it will return then largest numeral that is lower than or equal to the target
	
    const numeral = conversionArray.find(el => el.arabic <= num );

    resultString += numeral.roman;
    num -= numeral.arabic;                
}

return resultString;
};
