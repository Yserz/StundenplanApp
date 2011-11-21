
Ext.regController('AppController', {

    'index': function (options) {

        if (!App.views.mainView) {
            App.views.mainView = new App.views.MainView();
			App.views.mainView.setActiveItem(
				App.views.test
			);
        }else{
			App.views.mainView.setActiveItem(
				App.views.testtree,
				{ type: 'slide', direction: 'left' }
			);
		}

        
    },
	'newwindow': function (options) {
	
	    App.views.mainView.setActiveItem(
	        App.views.test2,
	        { type: 'slide', direction: 'left' }
	    );
	},
	'back': function (options) {
	
	    App.views.mainView.setActiveItem(
	        App.views.test,
	        { type: 'slide', direction: 'right' }
	    );
	}
});
App.controllers.appController = Ext.ControllerManager.get('AppController');