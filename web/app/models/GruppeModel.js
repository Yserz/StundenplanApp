Ext.regModel('GruppeModel', {
    fields  : [
                {name: 'id',     type: 'int'},
                {name: 'name',   type: 'string'},
                {name: 'url',   type: 'string'},
                {name: 'isStandard',   type: 'bool', defaultValue: false}
    ],
    hasMany: {model: 'TagModel', name: 'tag'},
    belongsTo: 'SemesterModel',
	validations: [
	  	        { type: 'presence', field: 'id' },
	  	        { type: 'presence', field: 'name' }
	]

});