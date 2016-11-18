// Open and close menu
(function(){
	let menuToggleOpen = document.getElementsByClassName('header_user')[0];	
	menuToggleOpen.addEventListener("click", menuToggleHandler, false);	
	let isOpen = false;
	function menuToggleHandler(){
		let menu = document.getElementsByClassName('openMenu')[0];
		if(!isOpen){		
			menu.style.display='block';
			isOpen = true;
		} else{
			menu.style.display='none';
			isOpen = false;
		}
	}	
})();