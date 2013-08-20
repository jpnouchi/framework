// Password strength meter v1.0
// Matthew R. Miller - 2007
// www.codeandcoffee.com
// Based off of code from  http://www.intelligent-web.co.uk

// Settings
// -- Toggle to true or false, if you want to change what is checked in the password
var bCheckNumbers = true;
var bCheckUpperCase = true;
var bCheckLowerCase = true;
var bCheckPunctuation = false;
var nPasswordLifetime = 365;

// Check password
function checkPassword(strPassword)
{
	// Reset combination count
	nCombinations = 0;
	
	// Check numbers
	if (bCheckNumbers)
	{
		strCheck = "0123456789";
		if (doesContain(strPassword, strCheck) > 0) 
		{ 
        		nCombinations += strCheck.length; 
    		}
	}
	
	// Check upper case
	if (bCheckUpperCase)
	{
		strCheck = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (doesContain(strPassword, strCheck) > 0) 
		{ 
        		nCombinations += strCheck.length; 
    		}
	}
	
	// Check lower case
	if (bCheckLowerCase)
	{
		strCheck = "abcdefghijklmnopqrstuvwxyz";
		if (doesContain(strPassword, strCheck) > 0) 
		{ 
        		nCombinations += strCheck.length; 
    		}
	}
	
	// Check punctuation
	if (bCheckPunctuation)
	{
		strCheck = ";:-_=+\|//?^&!.@$�#*()%~<>{}[]";
		if (doesContain(strPassword, strCheck) > 0) 
		{ 
        		nCombinations += strCheck.length; 
    		}
	}
	
	// Calculate
	// -- 500 tries per second => minutes 
    	var nDays = ((Math.pow(nCombinations, strPassword.length) / 500) / 2) / 86400;
 
	// Number of days out of password lifetime setting
	var nPerc = nDays / nPasswordLifetime;
	
	return nPerc;
}

// Runs password through check and then updates GUI 
function runPassword(strUser, strPassword, strFieldID,hiddenFortaleza)
{
	// Check password

	nPerc = checkPassword(strPassword);

	 // Get controls
    	var ctlBar = document.getElementById(strFieldID + "_bar"); 
    	var ctlText = document.getElementById(strFieldID + "_text");
        var nivelFortaleza=document.getElementById(hiddenFortaleza);

    	if (!ctlBar || !ctlText)
    		return;

    	// Set new width
    	var nRound = Math.round(nPerc * 100);
	if (nRound < (strPassword.length * 5)) 
	{ 
		nRound += strPassword.length * 5; 
	}
	if (nRound > 100)
		nRound = 100;
    	ctlBar.style.width = nRound + "%";
		
	// Check if password is same to user (only production)
//	if (document.domain=="www.b2mining.com" || document.domain=="b2mining.com" ||
//		document.domain=="www.e-mpresario.com.pe" || document.domain=="e-mpresario.com.pe")
//	{
		if (strPassword == strUser){nRound = 0;}
	//}
	// Check if password is weak/known
	if (strPassword == "123456" || strPassword == "password" || strPassword == "qwerty" || 
		strPassword == "abc123" || strPassword == "contraseña" || strPassword.length <6 )
		nRound = 0;
 
 	// Color and text
 	if (nRound > 95)
 	{
 		strText = labelMuySegura;
 		strColor = "#007D00";
        nivelFortaleza.value='3';
 	}
 	else if (nRound > 75)
 	{
 		strText = labelSegura;
 		strColor = "#00F000";
         nivelFortaleza.value='2';
	}
 	else if (nRound > 50)
 	{
 		strText = labelMediana;
 		strColor = "orange";
         nivelFortaleza.value='1';
 	}
 	else
 	{
 		strColor = "red";
 		strText = labelDebil;
        nivelFortaleza.value='0';
 	}

	ctlBar.style.backgroundColor = strColor;
	ctlText.innerHTML = "<span style='color: " + strColor + ";'>" + strText + "</span>";

}
 
// Checks a string for a list of characters
function doesContain(strPassword, strCheck)
{
    	nCount = 0; 
 
	for (i = 0; i < strPassword.length; i++) 
	{
		if (strCheck.indexOf(strPassword.charAt(i)) > -1) 
		{ 
	        	nCount++; 
		} 
	} 
 
	return nCount; 
} 

function isPasswordWeak(strFieldID)
{
	var ctlBar = document.getElementById(strFieldID + "_bar");
	if (!ctlBar) return;
	
	if(ctlBar.style.backgroundColor == "red")
		return true;
	else
		return false;
}



