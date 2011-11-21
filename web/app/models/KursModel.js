Ext.regModel('KursModel', {
    fields  : [
                {name: 'id',     type: 'int'},
                {name: 'name',   type: 'string'},
                {name: 'url',   type: 'string'},
                {name: 'dozent',   type: 'string'},
                {name: 'raum',   type: 'string'},
                {name: 'startTime',   type: 'time'},
                {name: 'endTime',   type: 'time'}
    ],
    belongsTo: 'TagModel',
	validations: [
	  	        { type: 'presence', field: 'id' },
	  	        { type: 'presence', field: 'startTime' },
	  	        { type: 'presence', field: 'endTime' },
	  	        { type: 'presence', field: 'name' }
	]

});