Ext.regModel('ListModelTree', {
    fields  : [
                {name: 'name',			type: 'string'},
				//{name: 'model',		type: 'string'},
				{name: 'items',			type: 'auto'},
				{name: 'startTime',		type: 'string'},
				{name: 'endTime',		type: 'string'},
				{name: 'dozent',		type: 'string'},
				{name: 'raum',			type: 'string'}
                //{name: 'url',		type: 'string'},
				//{name: 'items',		type: 'auto'}
    ]
    //hasMany: {model: 'KursModel', name: 'kurs'},
});