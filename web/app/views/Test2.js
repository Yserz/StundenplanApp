App.views.Test2 = Ext.extend(Ext.Panel, {

    layout: 'fit',
    html: 'hallo',

    initComponent: function () {

        this.newButton = new Ext.Button({
            text: 'New',
            ui: 'action',
            handler: this.onNewWindow,
            scope: this
        });
		
		this.backButton = new Ext.Button({
			ui: 'back',
			text: 'Back',
			handler: this.onGoBack,
			scope: this
		});

        this.topToolbar = new Ext.Toolbar({
            title: 'My Notes',
            items: [
				this.backButton,
                { xtype: 'spacer' },
            ]
        });

        this.dockedItems = [this.topToolbar];


        App.views.Test.superclass.initComponent.call(this);
    },
    onGoBack: function () {
        Ext.dispatch({
            controller: App.controllers.appController,
            action: 'back'
        });
    }
});