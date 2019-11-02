/*
	Monochromed by TEMPLATED
    templated.co @templatedco
    Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
*/

skel.init({
	prefix: 'css/style',
	resetCSS: true,
	boxModel: 'border',
	grid: {
		gutters: 50
	},
	breakpoints: {
		'mobile': {
			range: '-480',
			lockViewport: true,
			containers: 'fluid',
			grid: {
				collapse: true,
				gutters: 10
			}
		},
		'desktop': {
			range: '481-',
			containers: 1200
		},
		'1000px': {
			range: '481-1200',
			containers: 960
		}
	}
}, {
	panels: {
		panels: {
			navPanel: {
				breakpoints: 'mobile',
				position: 'left',
				style: 'reveal',
				size: '80%',
				html: '<div data-action="navList" data-args="nav"></div>'
			}
		},
		overlays: {
			titleBar: {
				breakpoints: 'mobile',
				position: 'top-left',
				height: 44,
				width: '100%',
				html: '<span class="toggle" data-action="togglePanel" data-args="navPanel"></span>' +
 '<span class="title" data-action="copyHTML" data-args="logo"></span>'
			}
		}
	}
	
	
});

// $(document).ready(function(){	
// 	let divWidth = $('#header').width();
// 	let divHeight = $('#header').height();

// 	moveCenter();  //色塊一開始就要在畫面中間
	
// 	$(window).resize(function(){  //視窗縮放移動也要在中間
// 		moveCenter()					
// 	});
// 	function moveCenter(){
// 	let winWidth = $(window).width();
// 	let winHeight = $(window).height();

// 	$('#header').css({
// 		// left : (winWidth-divWidth) / 2,
// 		// top : (winHeight-divHeight) / 2,
// 	});
//   }
// });