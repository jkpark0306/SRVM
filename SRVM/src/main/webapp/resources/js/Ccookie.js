/**
 * http://usejsdoc.org/
 */

function setCookie(cName, cValue, cHour){
	var expire = new Date();
	
	expire.setHours(expire.getHours() + cHour);
	cookies = cName + '=' + escape(cValue) + ';path=/';
	if(typeof cHour != 'undefined') cookies += ';expires=' + expire.toGMTString() + ';';
	document.cookie = cookies;
	
}

function getCookie(cName){
	   var value = document.cookie.match('(^|;) ?' + cName + '=([^;]*)(;|$)');
	   console.log('getCookie1 function : ' + document.cookie);
	   return value? value[2] : null;
}