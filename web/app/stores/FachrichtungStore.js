Ext.regStore('FachrichtungStore', {
    model: 'FachrichtungModel',
	
    sorters: [{
        property: 'name',
        direction: 'ASC'
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
		id: 'FachrichtungStore',
        url : 'http://localhost:8080/StundenplanAppServerSide/JSONServlet',
		//method: 'GET',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});

