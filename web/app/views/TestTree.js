App.views.TestTree = Ext.extend(Ext.NestedList, {
    fullscreen: true,
    title: 'StundenplanApp',
    store: App.stores.fachrichtungStoreTree,
	updateTitleText: true,
    getDetailCard: function(item, parent) {
        var itemData = item.attributes.record.data,
        parentData = parent.attributes.record.data,
        detailCard = new Ext.Panel({
            scroll: 'vertical',
            styleHtmlContent: true,
            tpl: ["<h2>{name}</h2>","{startTime} - {endTime}<br />{dozent}<br />{raum}"]
        });
        detailCard.update(itemData);
        this.backButton.setText(parentData.name);
        return detailCard;
    },
	getItemTextTpl: function() {
        var tplConstructor = '{name}' +
            '<tpl if="model === \'Artist\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} albums' +
                '</div>' +
            '</tpl>' +
            '<tpl if="model === \'Album\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} tracks' +
                '</div>' +
            '</tpl>' +
            '<tpl if="model === \'Track\'">'+
                '<div class="metadata">' +
                    ' Duration: {[Math.floor(values.duration/60)]}:{[values.duration%60]}' +
                '</div>' +
            '</tpl>';
        return tplConstructor;
    }/*,
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