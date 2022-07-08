//<![CDATA[
'use strict'
let HOME = (function ($) {
	return {

	}
}(jQuery));

$(document).ready(function () {
	'use strict'
	$('#loginForm').form({
		fields: {
			username: {
				identifier: 'username',
				rules: [
					{
						type: 'empty'
					}
				]
			},
			password: {
				identifier: 'password',
				rules: [
					{
						type: 'empty'
					},
					{
						type: 'minLength[6]',
					}
				]
			},
		},
		inline: true,
		on: 'blur'
	});
	$('#login').on('click', _.debounce(async event => {
		event.preventDefault();
		if ($('#loginForm').form('validate form')) {
			const loginData = $('#loginForm').form("get values");
			const response = await fetch('/demo/login',
				{
					headers: {
						"Content-Type": "application/json; charset=utf-8"
					},
					method: 'POST',
					cache: 'no-cache',
					body: JSON.stringify(loginData)
				}
			);
			if (response.ok) {
				const loginResult = await response.json();
				if (loginResult) {
					window.location.replace("/demo/pages/home");
				} else {
					const modal = DXCUtils.alertModal('MDOM000000ERR: Login fail', null);
					modal.modal('show');
				}
			} else {
				const modal = DXCUtils.alertModal('MDOM000001ERR: request error', null);
				modal.modal('show');
			}
		}
	}, 300, true));
});
//]]>