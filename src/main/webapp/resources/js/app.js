"user strict";
var app = app || {};
app = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했.... 이것만 에러가 나오나?.';
	let _, js, authjs;
	let run = x =>$.getScript(x+'/resources/js/cmm/router.js',
			()=>{
				$.extend(new Session(x));
			onCreate();
	}
			);
	let init =()=>{
		_ = $.ctx();
		js = $.js();
		authjs = js+'/cmm/auth.js';
		alert('app.init에서의 authjs = ' + authjs);
	}
	let onCreate = ()=>{
		init();
		$.when(
			$.getScript(authjs)
		)
		.done(()=>{
			auth.onCreate()
			}
		)
		.fail(()=>{
			alert('WHEN_ERR')}
		);
	}
	return {
		r : run
	}
})();