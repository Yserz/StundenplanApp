
App.stores.fachrichtungStoreTree = new Ext.data.TreeStore({
    model: 'ListModelTree',
	sortOnLoad: true,
	/*folderSort: true,
	sortRoot: 'name',*/
    sorters: [{
        property: 'name',
        direction: 'DESC'
    }],
    getGroupString: function (record) {
        if (record && record.data.name) {
            return record.get('name')[0];
        } else {
            return '';
        }
    },
	proxy: {
        type: 'ajax',
		//id: 'FachrichtungStoreTree',
		//url: 'http://localhost:8080/StundenplanAppServerSide/stundenplanJSON.json',
        url : 'http://localhost:8080/StundenplanAppServerSide/JSONServlet',
		//method: 'GET',
        reader: {
            type: 'tree',
            root: 'items'
        }
    }
});

App.stores.fachrichtungStoreTree.sort();
