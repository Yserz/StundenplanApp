Ext.regModel('FachrichtungModel', {
	idProperty: 'id',
    fields  : [
                {name: 'id',		type: 'int'},
                {name: 'name',		type: 'string'},
                {name: 'url',		type: 'string'}
    ],
    hasMany: {model: 'SemesterModel', name: 'semester'},
	validations: [
		  	    { type: 'presence', field: 'id' },
		  	    { type: 'presence', field: 'name' }
	]
});