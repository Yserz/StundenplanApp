Ext.regModel('SemesterModel', {
    fields  : [
                {name: 'id',		type: 'int'},
                {name: 'name',		type: 'string'},
                {name: 'url',		type: 'string'}
    ],
    hasMany: {model: 'GruppeModel', name: 'gruppe'},
    belongsTo: 'FachrichtungModel',
	validations: [
		  	    { type: 'presence', field: 'id' },
		  	    { type: 'presence', field: 'name' }
	]
});