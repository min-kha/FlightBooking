/*

Template:  E-shoppers - Responsive Multi-purpose HTML5 Template
Author: activous.in
Design and Developed by: activous.in

NOTE: This file contains all scripts for the actual Template.

*/

/*================================================
[  Table of contents  ]
================================================

:: Predefined Variables
:: Preloader
:: Mega menu
:: Javascript
:: Search Modal
:: Cart view
:: Slick Slider Customize
:: Product swiper
:: Quantity box
:: Back to top

======================================
[ End table content ]
======================================*/
//ACTIVOUS var

(function ($) {
	"use strict";
	var ACTIVOUS = {};

	/*************************
  Predefined Variables
*************************/
	var $window = $(window),
		$document = $(document);
	//Check if function exists
	$.fn.exists = function () {
		return this.length > 0;
	};



	/*************************
	        Preloader
	*************************/
	ACTIVOUS.preloader = function () {
		$("#load").fadeOut();
		$('#pre-loader').delay(0).fadeOut('slow');
	};

	/*************************
	       Mega menu
	*************************/
	ACTIVOUS.megaMenu = function () {
		loadScript(plugin_path + 'mega_menu.js', function () {
			var nav = $('#menu');
			var l = nav.attr('data-pos');
			var pos = 'horizontal';
			if (l) pos = l;
			nav.megaMenu({
				// DESKTOP MODE SETTINGS
				logo_align: 'left', // align the logo left or right. options (left) or (right)
				links_align: 'left', // align the links left or right. options (left) or (right)
				socialBar_align: 'left', // align the socialBar left or right. options (left) or (right)
				searchBar_align: 'right', // align the search bar left or right. options (left) or (right)
				trigger: 'hover', // show drop down using click or hover. options (hover) or (click)
				effect: 'expand-top', // drop down effects. options (fade), (scale), (expand-top), (expand-bottom), (expand-left), (expand-right)
				effect_speed: 400, // drop down show speed in milliseconds
				sibling: true, // hide the others showing drop downs if this option true. this option works on if the trigger option is "click". options (true) or (false)
				outside_click_close: true, // hide the showing drop downs when user click outside the menu. this option works if the trigger option is "click". options (true) or (false)
				top_fixed: false, // fixed the menu top of the screen. options (true) or (false)
				sticky_header: true, // menu fixed on top when scroll down down. options (true) or (false)
				sticky_header_height: 250, // sticky header height top of the screen. activate sticky header when meet the height. option change the height in px value.
				menu_position: pos, // change the menu position. options (horizontal), (vertical-left) or (vertical-right)
				full_width: false, // make menu full width. options (true) or (false)
				// MOBILE MODE SETTINGS
				mobile_settings: {
					collapse: true, // collapse the menu on click. options (true) or (false)
					sibling: true, // hide the others showing drop downs when click on current drop down. options (true) or (false)
					scrollBar: true, // enable the scroll bar. options (true) or (false)
					scrollBar_height: 400, // scroll bar height in px value. this option works if the scrollBar option true.
					top_fixed: false, // fixed menu top of the screen. options (true) or (false)
					sticky_header: false, // menu fixed on top when scroll down down. options (true) or (false)
					sticky_header_height: 200 // sticky header height top of the screen. activate sticky header when meet the height. option change the height in px value.
				}
			});
			// Dynamic active menu
			var path = window.location.pathname.split("/").pop();
			var target = $('header .mega-menu a[href="' + path + '"]');
			target.parent().addClass('active');
			$('header .mega-menu li.active').parents('li').addClass('active');

		});
	};




	/****************************************************
	          javascript
	****************************************************/
	var _arr = {};

	function loadScript(scriptName, callback) {
		if (!_arr[scriptName]) {
			_arr[scriptName] = true;
			var body = document.getElementsByTagName('body')[0];
			var script = document.createElement('script');
			script.type = 'text/javascript';
			script.src = scriptName;
			// then bind the event to the callback function
			// there are several events for cross browser compatibility
			// script.onreadystatechange = callback;
			script.onload = callback;
			// fire the loading
			body.appendChild(script);
		} else if (callback) {
			callback();
		}
	}
	/****************************************************
	          Search modal open
	****************************************************/

	$(function () {
		$('a[href="#search"]').on('click', function (event) {
			event.preventDefault();
			$('#search').addClass('open');
			$('#search > form > input[type="search"]').focus();
			$( "body" ).addClass('body-scroll-toggle');
		});

		$('#search, #search button.close').on('click keyup', function (event) {
			if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
				$(this).removeClass('open');
				$( "body" ).removeClass('body-scroll-toggle');
			}
		});
	});


	/*************************
	  Slick SLider Customize
	*************************/

	$(document).ready(function () {
		$(".slickcarousel").slick({
			rtl: false, // If RTL Make it true & .slick-slide{float:right;}
			autoplay: true,
			autoplaySpeed: 5000, //  Slide Delay
			speed: 800, // Transition Speed
			slidesToShow: 4, // Number Of Carousel
			slidesToScroll: 1, // Slide To Move 
			pauseOnHover: false,
			appendArrows: $(".arrows"), // Class For Arrows Buttons
			prevArrow: '<span class="slick-Prev"></span>',
			nextArrow: '<span class="slick-Next"></span>',
			easing: "linear",
			responsive: [{
				breakpoint: 801,
				settings: {
					slidesToShow: 3,
				}
			}, {
				breakpoint: 641,
				settings: {
					slidesToShow: 3,
				}
			}, {
				breakpoint: 481,
				settings: {
					slidesToShow: 1,
				}
			}, ],
		});
	});

	$(document).ready(function () {
		$(".slickcarousel-tab").slick({
			rtl: false, // If RTL Make it true & .slick-slide{float:right;}
			autoplay: true,
			autoplaySpeed: 5000, //  Slide Delay
			speed: 800, // Transition Speed
			slidesToShow: 4, // Number Of Carousel
			slidesToScroll: 1, // Slide To Move 
			pauseOnHover: false,
			appendArrows: $(".arrows-tab"), // Class For Arrows Buttons
			prevArrow: '<span class="slick-Prev"></span>',
			nextArrow: '<span class="slick-Next"></span>',
			easing: "linear",
			responsive: [{
				breakpoint: 801,
				settings: {
					slidesToShow: 3,
				}
			}, {
				breakpoint: 641,
				settings: {
					slidesToShow: 3,
				}
			}, {
				breakpoint: 481,
				settings: {
					slidesToShow: 1,
				}
			}, ],
		});
	});

	/*************************
	  Product swiper
	*************************/

	$(document).ready(function () {
		var galleryTop = new Swiper(".gallery-top", {
			navigation: {
				nextEl: ".swiper-button-next",
				prevEl: ".swiper-button-prev"
			},
			loop: true,
			slidesPerView: 1,
			spaceBetween: 10,
			loopedSlides: 50,
			observer: true,
			observeParents: true
		});
		var galleryThumbs = new Swiper(".gallery-thumbs", {
			spaceBetween: 10,
			slidesPerView: "auto",
			loop: true,
			slideToClickedSlide: true,
			centeredSlides: true,
			loopedSlides: 50,
			observer: true,
			observeParents: true
		});

		galleryTop.controller.control = galleryThumbs;
		galleryThumbs.controller.control = galleryTop;
		$(window).resize(function () {
			galleryTop.update();
			galleryThumbs.update();
		});
	});


	/*************************
	     Quantity box
	*************************/

	$(function () {
		$('.box').on('click', '.minus', function () {
			var $quantity = $(this).siblings('.quantity'),
				value = +$quantity.val();

			if (value > 1) {
				$quantity.val(value - 1);
			}
		});

		$('.box').on('click', '.plus', function () {
			var $quantity = $(this).siblings('.quantity'),
				value = +$quantity.val();

			if (value < 10) {
				$quantity.val(value + 1);
			}
		});
	});


	/*************************
	     Back to top
	*************************/
	$(window).scroll(function () {
		if ($(this).scrollTop() >= 50) { // If page is scrolled more than 50px
			$('#return-to-top').fadeIn(200); // Fade in the arrow
		} else {
			$('#return-to-top').fadeOut(200); // Else fade out the arrow
		}
	});
	$('#return-to-top').click(function () { // When arrow is clicked
		$('body,html').animate({
			scrollTop: 0 // Scroll to top of body
		}, 500);
	});
	
	
	
	/****************************************************
	     ACTIVOUS Window load and functions
	****************************************************/
	//Window load functions
	$window.on("load", function () {
		ACTIVOUS.preloader();
	});
	//Document ready functions
	$document.ready(function () {
		ACTIVOUS.megaMenu();
		//        ACTIVOUS.mobileview();
	});
})(jQuery);
