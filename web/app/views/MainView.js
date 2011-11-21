
App.views.MainView = Ext.extend(Ext.Panel, {
    fullscreen: true,
    layout: 'card',
    cardSwitchAnimation: 'slide',
	direction: 'left',
    initComponent: function () {
		
        Ext.apply(App.views, {
            test: new App.views.Test(),
			test2: new App.views.Test2()
			//testtree: new App.views.TestTree()
        });

        this.items = [
            App.views.test,
			App.views.test2
			//App.views.testtree
        ]

        this.on('render', function () {
            Ext.StoreMgr.get('FachrichtungStore').load({
                callback: function() {
                	var store = Ext.StoreMgr.get('FachrichtungStore');
                    var fr = store.first();
                    console.log("Fachrichtung " + fr.get('name') + ":");
                    fr.semester().each(function(semester) {
                        console.log("Semester-name: " + semester.get('name') + ", which contains items:");
                        semester.gruppe().each(function(gruppe) {
                        	console.log("Gruppe: "+ gruppe.get('name'));
                        	gruppe.tag().each(function(tag) {
                        		console.log("Tag: "+ tag.get('name'));
                        		tag.kurs().each(function(kurs) {
                        			console.log("kurs: "+ kurs.get('name'));
                            	});
                        	});
                        });
						console.log("------------------------------------------------------------------------------------");
                    });
					
                }
            });
        });
		
		App.views.MainView.superclass.initComponent.call(this);
    }
});
