
App.stores.fachrichtungStoreTree = new Ext.data.TreeStore({
    model: 'ListModelTree',
	sortOnLoad: true,
	proxy: {
        type: 'ajax',
        //url : 'http://localhost:8080/StundenplanAppServerSide/JSONServlet',
        url : 'http://localhost:8080/StundenplanApp/JSONServlet',
		//url : 'http://localhost:8080/StundenplanAppServerSide/stundenplanJSON.json',
        reader: {
            type: 'tree',
            root: 'items'
        }
    }
});

