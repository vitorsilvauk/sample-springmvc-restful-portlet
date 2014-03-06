Ext.require(['Ext.data.*', 'Ext.grid.*']);

Ext.define('HelloSample', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'sampleId',
        type: 'int',
        useNull: true
    }, 'sampleName', 'sampleAddress'],
    idProperty:'sampleId',
    validations: [{
        type: 'length',
        field: 'sampleName',
    }, {
        type: 'length',
        field: 'sampleAddress',
        min: 1
    }]
});

function renderRESTFulData ( config ){
	var ctxPath = config['ctxPath'];
	var divId = config['divId'];
	var hasDeletePermissions = config['hasDeletePermission'];
	var hasUpdatePermissions = config['hasUpdatePermission'];
	var hasCreatePermissions = config['hasAddPermission'];
    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'HelloSample',
        proxy: {
            type: 'rest',
            url: '',
            api: {
                read: ctxPath+'/services/helloSample',
                create: ctxPath+'/services/helloSample',
                update: ctxPath+'/services/helloSample/sampleId',
                destroy: ctxPath+'/services/helloSample/sampleId'
            },

            reader: {
                type: 'json',
                root: 'data'
            },
            writer: {
                type: 'json'
            }
        },
        listeners: {
            write: function(store, operation){
                var record = operation.getRecords()[0],
                    name = Ext.String.capitalize(operation.action),
                    verb;
                    
                    
                if (name == 'Destroy') {
                    record = operation.records[0];
                    verb = 'Destroyed';
                } else {
                    verb = name + 'd';
                }
              
                
            }
        }
    });
    
    var rowEditing ;

    rowEditing = Ext.create('Ext.grid.plugin.RowEditing',{
    	
    	listeners:{
    		 beforeedit: function(editor, context){
    		        return hasUpdatePermissions=='true';
    		    }
    	}
    });
    
    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        title: 'HelloSamples',
        store: store,
        iconCls: 'icon-user',
        columns: [
                  {
            text: 'SampleId',
            sortable: true,
            flex: 25 / 100,
            dataIndex: 'sampleId'
        }, {
            text: 'SampleName',
            sortable: true,
            flex: 35 / 100,
            dataIndex: 'sampleName',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'SampleAddress',
            sortable: true,
            flex: 40 / 100,
            dataIndex: 'sampleAddress',
            field: {
                xtype: 'textfield'
            }
        }],
        dockedItems: [{
            xtype: 'toolbar',
            items: [{
                text: 'Add',
                iconCls: 'icon-add',
                disabled: hasCreatePermissions=='false',
                handler: function(){
                    // empty record
                    store.insert(0, new HelloSample());
                    rowEditing.startEdit(0, 0);
                }
            }, '-', {
                itemId: 'delete',
                text: 'Delete',
                iconCls: 'icon-delete',
                disabled: true,
                handler: function(){
                    var selection = grid.getView().getSelectionModel().getSelection()[0];
                    if (selection) {
                        store.remove(selection);
                    }
                }
            }]
        }],
        renderTo: divId
    });
    grid.getSelectionModel().on('selectionchange', function(selModel, selections){
        if(hasDeletePermissions=="true")
    	grid.down('#delete').setDisabled(selections.length === 0);
    });
}