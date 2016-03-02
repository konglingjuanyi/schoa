	/**
	 * 教学文件上传控件
	 */
	var FileUpLoadWindow = function(callback){
		var self = this;
		
		this.jiaoxueFileId = 0;
		
		this.uploadForm = new Ext.form.FormPanel({
			fileUpload : true,
			frame : false,
			bodyStyle : 'padding: 20px 10px 0 10px;',
			height : 300,
			width : 400,
			defaults : {
				anchor : '95%',
				allowBlank : false
			},
			items : [{
				xtype : 'fileuploadfield',
				id : 'form-file',
				emptyText : '选择文件...',
				fieldLabel : '选择文件',
				name : 'upfile',
				buttonText : '浏览...'
			} ],
			buttons : [ {
				text : '上传',
				handler : function() {
					if(self.jiaoxueFileId <= 0){
						alert('教学文件id为空！');
						return;
					}
					
					var fileForm = self.uploadForm.getForm();
					if (fileForm.isValid()) {
						fileForm.submit({
							url : 'jiaoxueFileUpload.do?jiaoxueFileId=' + self.jiaoxueFileId,
							waitMsg : '正在上传，请等待...',
							success : function(fp, action) {
								callback(fp,action);
							},
							failure : function(form, action) {
								var val = action.result.msg;
								if (val == null || val == 'undefined' || val == 'null' || val == '') {
									alert("操作失败，\n\t3请联系管理员！");
								} else {
									alert(action.result.msg);
								}
						    }
						});
					}
				}
			}, {
				text : '取消',
				handler : function() {
					self.hide();
				}
			} ]
		});
		FileUpLoadWindow.superclass.constructor.call(this, {
			title : '上传教学文件',
			width : 400,
			height : 150,
			items : [self.uploadForm]
		});
	};
	
	/**
	 * 文件上传
	 */
	Ext.extend(FileUpLoadWindow, com.custom.Window, {});