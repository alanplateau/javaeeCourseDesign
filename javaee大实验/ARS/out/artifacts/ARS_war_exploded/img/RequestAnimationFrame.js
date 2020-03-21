/*
 * Copyright(c)2002-2019
 *    项目名称:ARSUserPart
 *    文件名称:RequestAnimationFrame.js
 *    Date:2019/12/15 下午4:38
 *    Author:高源
 */

/**
 * Provides requestAnimationFrame in a cross browser way.
 * /paulirish.com/2011/requestanimationframe-for-smart-animating/
 */

if ( !window.requestAnimationFrame ) {

	window.requestAnimationFrame = ( function() {

		return window.webkitRequestAnimationFrame ||
		window.mozRequestAnimationFrame ||
		window.oRequestAnimationFrame ||
		window.msRequestAnimationFrame ||
		function( /* function FrameRequestCallback */ callback, /* DOMElement Element */ element ) {

			window.setTimeout( callback, 1000 / 60 );

		};

	} )();

}
