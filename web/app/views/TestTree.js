App.views.TestTree = Ext.extend(Ext.NestedList, {
    fullscreen: true,
    title: 'StundenplanApp',
    store: 'FachrichtungStoreTree'
    /*getDetailCard: function(item, parent) {
        var itemData = item.attributes.record.data,
        parentData = parent.attributes.record.data,
        detailCard = new Ext.Panel({
            scroll: 'vertical',
            styleHtmlContent: true,
            tpl: ["<h2>{name}</h2>","hallo"]
        });
        detailCard.update(itemData);
        this.backButton.setText(parentData.text);
        return detailCard;
    },*/
/*
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

		
        App.views.TestTree.superclass.initComponent.call(this);
    },
    onGoBack: function () {
        Ext.dispatch({
            controller: App.controllers.appController,
            action: 'back'
        });
    }*/
});