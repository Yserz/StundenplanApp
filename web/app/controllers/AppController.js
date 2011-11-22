
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

        
    }
});
App.controllers.appController = Ext.ControllerManager.get('AppController');