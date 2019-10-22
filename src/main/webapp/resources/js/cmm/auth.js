"user strict";
var auth = auth || {}
auth =(()=>{
	let _, js,auth_vue_js
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		auth_vue_js = js+'/vue/auth_vue.js'
	}
	let setContentView =()=>{
    	login()
    }
	//$().on('click',()=>{}) 원래문법
	//$().click(()=>{}) 래식이 문법
	//$.ajax('sdf',{}) 원래문법
	let login =()=>{
		$('body').html(auth_vue.login_body)
		$('<a>',{
				text : '회원가입 이동',
				href : '#',
				click : () =>{
					join()
				}
			})
			.appendTo('#a_go_join')
		$('<button>',{
			text : 'Sign in',
			type : 'submit',
			click : e=>{
				e.preventDefault();
				let data = { uid : $('#uid').val(),
						upw : $('#upw').val()
				}
				alert('로그인 전송아이디 : '+data.uid)
				$.ajax({
					url : _+'/users/login',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : d =>{
						alert('로그인성공')
						alert(d.uid+' 님 환영합니다.')
						mypage(d)
					},
					error : e => {
						alert('로그인 ajax 실패')
					}
				})
			}
		})
		.addClass('btn btn-lg btn-primary btn-block')
		.appendTo('#a_login_button')
	}
	let join =()=>{
		alert('회원가입 클릭!!');
		$('body').html(auth_vue.join_body)
		$('<button>',{
			text : 'Continue to checkout',
			href : '#',
			type : 'submit',
			click : e=>{
				e.preventDefault();
				let data = { uid : $('#uid').val(),
						upw : $('#upw').val(),
						uname : $('#uname').val(),
						age : $('#age').val()
				}
				alert('조인 전송아이디 :'+data.uid)
				$.ajax({
					url : _+'/users',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(data),
						//{ uId : $('#uid').val ,uPw : $('#upw)}이 원형태
					contentType : 'application/json',      //meam
					success : d => {
						alert('ajax 조인 성공아이디 : '+ d.uid +
								'ajax 조인 성공비번: ' + d.upw)
						login()
					},
					error : e => {
						alert('조인 ajax 실패..!!!!!!!!!!')
					}
				})
			}
		})
		.addClass('btn btn-primary btn-lg btn-block')
		.appendTo('#a_join_button')
	}
	let onCreate =()=>{
		alert('온크리진입')
		init()
		$.getScript(auth_vue_js).done(()=>{
			alert('겟스크립트 진입')
			setContentView()
		})
	}
	let mypage = (x) =>{
		alert('마이페이지')
		$('#uid').html(
			$('<h1>',{text : 'asdff'})
			.addClass('form-control')
			.appendTo('#uid')
		)
	}
	return {onCreate};
})();