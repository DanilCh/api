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

	let scrollSideBar = document.getElementsByClassName('sideBar')[0];

	scrollSideBar.addEventListener("wheel", sideBarScroling, false);
		var srollDown = false;// this var created for sideBarScroling --- to understant in which direction we scroll

		function sideBarScroling(e){
		    let dir = e.deltaY,
		    	sideBar_height = this.clientHeight,
		    	myVwindows_height = window.innerHeight,
		    	diferents_height = sideBar_height - myVwindows_height;
		    
		    if((dir < 0) && srollDown){
		    	this.style.marginTop = "0px";
		    	srollDown = false;
		    } else if ((dir > 0) && !srollDown){
		    	this.style.marginTop = -diferents_height + "px";
		    	srollDown = true;
		    }
   			e.preventDefault();	
		}	
})();