
App.views.MainView = Ext.extend(Ext.Panel, {
    fullscreen: true,
    layout: 'card',
    cardSwitchAnimation: 'slide',
	direction: 'left',
    initComponent: function () {
		
        Ext.apply(App.views, {
			testtree: new App.views.TestTree()
        });

        this.items = [
			App.views.testtree
        ]

        this.on('render', function () {
        });
		App.views.MainView.superclass.initComponent.call(this);
    }
});
