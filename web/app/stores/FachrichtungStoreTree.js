
App.stores.fachrichtungStoreTree = new Ext.data.TreeStore({
    model: 'ListModelTree',
	//model: 'ListItem',
	//defaultRootProperty: 'data',
    /*sorters: [{
        property: 'name',
        direction: 'ASC'
    }],*/
    /*getGroupString: function (record) {
        if (record && record.data.name) {
            return record.get('name')[0];
        } else {
            return '';
        }
    },*/
	proxy: {
        type: 'ajax',
		//id: 'FachrichtungStoreTree',
		url: 'http://localhost:8080/StundenplanAppServerSide/stundenplanJSON.json',
        //url : 'http://localhost:8080/StundenplanAppServerSide/JSONServlet',
		//method: 'GET',
        reader: {
            type: 'tree',
            root: 'items'
        }
    }
});

