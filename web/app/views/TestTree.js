App.views.TestTree = Ext.extend(Ext.NestedList, {
    fullscreen: true,
    title: 'StundenplanApp',
    store: App.stores.fachrichtungStoreTree,
	displayField: 'name',
	styleHtmlContent: true,
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
        var tplConstructor = '<h2>{name}</h2>' +
            '<tpl if="model === \'Fachbereich\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} Semester' +
                '</div>' +
            '</tpl>' +
            '<tpl if="model === \'Semester\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} Gruppe(n)' +
                '</div>' +
            '</tpl>' +
			'<tpl if="model === \'Gruppe\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} Tag(e)' +
                '</div>' +
            '</tpl>' +
			'<tpl if="model === \'Tag\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} Kurs(e)' +
                '</div>' +
            '</tpl>' +
            '<tpl if="model === \'Kurs\'">'+
                '<div class="metadata">' +
                    ' <b>Zeit: {[values.startTime]} - {[values.endTime]}</b><br />' +
					' Raum: {[values.raum]}<br />' +
					' Dozent: {[values.dozent]}<br />' +
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