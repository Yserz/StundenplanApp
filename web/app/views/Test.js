App.views.Test = Ext.extend(Ext.Panel, {
    //layout: 'fit',
    
    initComponent: function () {
		/*
		this.setProfile = function (profile) {
			if (profile=='portraitPhone') {
				this.setActiveItem(this.menu);
			} else if (profile=='landscapePhone') {
				this.remove(this.menu, false);
				this.setActiveItem(this.page);
			} else if (profile=='portraitTablet') {
				this.removeDocked(this.menu, false);
			} else if (profile=='landscapeTablet') {
				this.addDocked(this.menu);
			}
		};
		*/
        this.newButton = new Ext.Button({
            text: 'New',
            ui: 'action',
            handler: this.onNewWindow,
            scope: this
        });

		this.backButton = new Ext.Button({
			ui: 'back',
			text: 'Back'
		});

		this.menuButton = new Ext.Button({
			iconCls: 'list',
			iconMask: true
		});

        this.topToolbar = new Ext.Toolbar({
            title: 'StundenplanApp',
            items: [
				//this.backButton,
                { xtype: 'spacer' },
                this.newButton
            ]
        });
		
		

        this.dockedItems = [this.topToolbar];
		
		var notesList = new Ext.List({
            store: 'FachrichtungStore',
            emptyText: '<div style="margin:5px;">No notes cached.</div>',
            onItemDisclosure: true,
			grouped: true,
			//singleSelect: true,
			//allowDeselect: false,
			plugins: [{
				ptype: 'pullrefresh'
			}],
            itemTpl: '<div class="list-item-title">{id}<br>{name}</div>' +
                            '<div class="list-item-narrative">{url}</div>'

        });
		
		this.items = [notesList];
		
        App.views.Test.superclass.initComponent.call(this);
    },
    onNewWindow: function () {
        Ext.dispatch({
            controller: App.controllers.appController,
            action: 'newwindow'
        });
    }
});