App.views.TestTree = Ext.extend(Ext.NestedList, {
    fullscreen: true,
	layout: 'card',
    title: 'StundenplanApp',
    store: App.stores.fachrichtungStoreTree,
	displayField: 'name',
	styleHtmlContent: true,
	emptyText: 'No Courses found!',
	initComponent: function() {
		App.views.TestTree.superclass.initComponent.apply(this, arguments);
	},
	listeners: {
		render: function() {
			var myButton = new Ext.Button({
				type: 'light',
				iconMask: true,
				iconCls: 'refresh',
				scope: this,
				handler: this.onReload
			});
			//this.toolbar.add(myButton);
			this.toolbar.setDocked('bottom');
		}	
	},
    /*getDetailCard: function(item, parent) {
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
    },*/
	getItemTextTpl: function() {
        var tplConstructor = '<h2>{name}</h2>' +
            '<tpl if="model === \'Studiengang\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} aktive(s) Semester' +
                '</div>' +
            '</tpl>' +
            '<tpl if="model === \'Semester\'">'+
                '<div class="metadata">' +
                    ' {[values.items.length]} Gruppe(n)' +
                '</div>' +
            '</tpl>' +
			'<tpl if="model === \'Gruppe\'">'+
                '<div class="metadata">' +
                    /*' {[values.items.length]} Tag(e)' +*/
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
					' {[values.bemerkung]}<br />' +
                '</div>' +
            '</tpl>';
        return tplConstructor;
    },
	/**
    * Action trigger when press the add button
    *
    * @return {void}
    */
    onReload: function() {
		//App.stores.fachrichtungStoreTree.read();
		this.store.update();
    }
	
});
