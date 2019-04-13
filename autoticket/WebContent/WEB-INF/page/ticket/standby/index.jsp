<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
	<head>
		<title>余票查询</title>	
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/default/easyui.css"/>' title="default">
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/gray/easyui.css"/>' title="gray">
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/black/easyui.css"/>' title="black">
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/bootstrap/easyui.css"/>' title="bootstrap">
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/metro/easyui.css"/>' title="metro">
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/easyui/themes/icon.css"/>'>
		<script type="text/javascript" src='<c:url value="/comresource/easyui/jquery.min.js"/>'></script>
		<script type="text/javascript" src='<c:url value="/comresource/easyui/jquery.easyui.min.js"/>'></script>
		<script type="text/javascript" src='<c:url value="/comresource/js/easyuicrud.js"/>'></script>
		<link rel="stylesheet" type="text/css" href='<c:url value="/comresource/css/pagebase.css"/>'>	
		<script type="text/javascript" src='<c:url value="/comresource/date/WdatePicker.js"/>'></script>
		<script type="text/javascript">
		$(function(){
			ewcmsBOBJ = new EwcmsBase();
			ewcmsBOBJ.setQueryURL('<c:url value="/ticket/standby/query.do"/>');		
			ewcmsBOBJ.delToolItem("修改");
			ewcmsBOBJ.delToolItem("删除");
			ewcmsBOBJ.delToolItem("缺省查询");
			ewcmsBOBJ.delToolItem("新增");
			ewcmsBOBJ.delToolItem("查询");
			ewcmsBOBJ.delFrozenItem("ck");
			ewcmsBOBJ.openDataGrid('#tt',{
                columns:[[
						{field:'departurePier',title:'出发码头',width:150,sortable:true},
						{field:'arrivalPier',title:'抵达码头',width:150,sortable:true},
						{field:'flightNumber',title:'航班号',width:150,sortable:true},
						{field:'flightTime',title:'开航时间',width:150,sortable:true},
						{field:'boatPort',title:'登船口',width:80,sortable:true},
						{field:'price',title:'票价',width:150,sortable:true},
						{field:'number',title:'余票',width:150,sortable:true}
                  ]],
                  toolbar:'#tb',
                  pagination:false
			});

			ewcmsOOBJ = new EwcmsOperate();
			ewcmsOOBJ.setQueryURL(ewcmsBOBJ.getQueryURL());
			
		});
		</script>		
	</head>
	<body class="easyui-layout">
		<div region="center" style="padding:2px;" border="false">
	 		<table id="tt" fit="true" pageSize=999 pageList="[50,200,500,999,]" ></table>	
	 	</div>
		<div id="tb" style="padding:5px;height:auto;">
	        <div class="toolbar" style="margin-bottom:2px">
			</div>
        	<div>
        	<form id="queryform" style="padding:0;margin:0;">
        		<table class="formtable">
              		<tr>
              			<td >									
              				<select id="flightLineName" name="flightLineName" class="easyui-combobox" data-options="
              				panelHeight:'auto',
              				panelWidth:'auto',
              				editable:false,
              				width:300">
										<option value="">--请选择航线--</option>
										<option value="邮轮中心厦鼓码头-三丘田码头（环鼓海上游+上岛）">邮轮中心厦鼓码头-三丘田码头（环鼓海上游+上岛）</option>
										<option value="邮轮中心厦鼓码头-内厝澳码头">邮轮中心厦鼓码头-内厝澳码头</option>
										<option value="邮轮中心厦鼓码头-内厝澳码头(普)">邮轮中心厦鼓码头-内厝澳码头(普)</option>
										<option value="邮轮中心厦鼓码头-三丘田码头">邮轮中心厦鼓码头-三丘田码头</option>
										<option value="嵩鼓码头（嵩屿）-内厝澳码头">嵩鼓码头（嵩屿）-内厝澳码头</option>
										<option value="厦门轮渡码头-三丘田码头（夜航）">厦门轮渡码头-三丘田码头（夜航）</option>
							</select>
						</td>
              			<td ><input type="text" id="flightDate" name="flightDate" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="请选择日期" /></td>		
              			<td>
            				<a id="tb-query" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="querySearch();">查询</a>
           					<a id="tb-clear" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#queryform').form('reset');">清除</a>
           				</td>
           			</tr>         			
           		</table>
          	</form>
       		</div>
		</div>   	
	</body>
	<script language="JavaScript"> 
		var today=new Date();
		var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
		$("#flightDate").attr('value',submitTime);
	</script>  
</html>