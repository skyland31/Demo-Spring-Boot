//<![CDATA[
'use strict'
let GIM = (function ($) {
	return {


	}
}(jQuery));

$(document).ready(async function () {
	'use strict'
	$.fn.dataTable.moment('DD/MM/YYYY HH:mm:ss');
	const response = await DXCUtils.callAPI("/master/gim/header/all", "GET", null);
	$('#tableSearchRult').DataTable({
		"data": response,
		"columns": [
			{
				"data": "gimType",
				"className": "dt-body-left"
			},
			{
				"data": "gimDesc",
				"className": "dt-body-left"
			},
			{
				"data": "cdLength",
				"className": "dt-body-right"
			},
			{
				"data": "field1Label",
				"className": "dt-body-left"
			},
			{
				"data": "field2Label",
				"className": "dt-body-left"
			},
			{
				"data": "field3Label",
				"className": "dt-body-left"
			},
			{
				"data": "activeFlag",
				"className": "dt-body-center"
			},
			{
				"data": "modifiedBy",
				"className": "dt-body-left"
			},
			{
				"data": "modifiedDt",
				"className": "dt-body-left",
				"render": function (data, row) {
					return DXCUtils.formatDate(data, "DD/MM/YYYY HH:mm:ss");
				}
			},
		]
	});
});
//]]>