Ext.regModel('ListModelTree', {
    fields  : [
                {name: 'name',		type: 'string'},
                //{name: 'url',		type: 'string'},
				{name: 'items',		type: 'auto'}
    ]
    //hasMany: {model: 'KursModel', name: 'kurs'},
});