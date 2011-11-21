Ext.regModel('RootModel', {
    fields  : [
                {name: 'id',		type: 'int'},
                {name: 'date',		type: 'date'},
                {name: 'url',		type: 'string'}
    ],
    hasMany: {model: 'FachrichtungModel', name: 'data'},
	validations: [
		  	    { type: 'presence', field: 'id' },
		  	    { type: 'presence', field: 'date' }
	]
});