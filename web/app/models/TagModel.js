Ext.regModel('TagModel', {
    fields  : [
                {name: 'id',     type: 'int'},
                {name: 'name',   type: 'string'},
                {name: 'anzKurse',   type: 'int'}
    ],
    hasMany: {model: 'KursModel', name: 'kurs'},
    belongsTo: 'GruppeModel',
	validations: [
		  	    { type: 'presence', field: 'id' },
		  	    { type: 'presence', field: 'name' }
	]
});