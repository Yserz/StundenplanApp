
App.stores.fachrichtungStoreTree = new Ext.data.TreeStore({
    model: 'ListModelTree',
	sortOnLoad: true,
	proxy: {
        type: 'ajax',
        //url : 'http://localhost:8080/StundenplanAppServerSide/JSONServlet',
        //url : 'http://localhost:8080/StundenplanApp/JSONServlet',
		//url : 'http://localhost:8080/StundenplanAppServerSide/stundenplanJSON_S.json',
        //url : 'http://192.168.178.37:8080/StundenplanAppServerSide/JSONServlet',
        url : 'http://stundenplanapp.fh-brandenburg.de/StundenplanApp/JSONServlet',
        reader: {
            type: 'tree',
            root: 'items'
        }
    }
});

