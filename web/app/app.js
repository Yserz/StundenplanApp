/**
 * This file sets application-wide settings and 
 * launches the application when everything has
 * been loaded onto the page. 
 *
 */ 
var App = new Ext.Application({
    name					: 'App',
    //tabletStartupScreen 	: 'res/gfx/app/*.png',
    //phoneStartupScreen  	: 'res/gfx/app/*.png',
    //icon                	: 'res/gfx/app/*.png',
    //glossOnIcon         	: false,
    useLoadMask				: true,

    launch: function () {
        this.launched = true;
        this.mainLaunch();
    },
    mainLaunch: function() {
        //if (!device || !this.launched) {return;}
        console.log('mainLaunch');
        Ext.dispatch({
            controller: App.controllers.appController,
            action: 'index'
        });
    }/*,
	profiles: {
		portraitPhone: function() {
			return Ext.is.Phone && Ext.orientation == 'portrait';
		},
		landscapePhone: function() {
			return Ext.is.Phone && Ext.orientation == 'landscape';
		},
		portraitTablet: function() {
			return !Ext.is.Phone && Ext.orientation == 'portrait';
		},
		landscapeTablet: function() {
			return !Ext.is.Phone && Ext.orientation == 'landscape';
		}
	}*/
});