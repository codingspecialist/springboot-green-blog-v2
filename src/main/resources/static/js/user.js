// 1. 이벤트 리스너
$("#btn-join").click(() => {
    join();
});

$("#btn-login").click(() => {
    login();
});

$("#btn-update").click(() => {
    update();
});

// 2. 기능

// 회원정보 수정 함수
async function update() {
    let id = $("#id").val();
    let updateDto = {
        password: $("#password").val(),
        email: $("#email").val(),
        addr: $("#addr").val()
    }

    let response = await fetch(`/s/api/user/${id}`, {
        method: "PUT",
        body: JSON.stringify(updateDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });
    let responseParse = await response.json();

    if (responseParse.code == 1) {
        alert("업데이트 성공");
        location.href = `/s/user/${id}`;
    } else {
        alert("업데이트 실패");
    }
}

// 유저네임 기억하기 함수 httpOnly 속성이 걸려있으면 안된다 주의하자!!
function usernameRemember() {
    let cookies = document.cookie.split("=");
    //console.log(cookies[1]);
    $("#username").val(cookies[1]);
}
usernameRemember();

// 회원가입 요청 함수
async function join() {
    // (1) username, password, email, addr 을 찾아서 오브젝트로 만든다.
    let joinDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        email: $("#email").val(),
        addr: $("#addr").val()
    }

    // (2) fetch 요청한다. (json으로 변환해서)
    let response = await fetch("/join", {
        method: "POST",
        body: JSON.stringify(joinDto),
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });
    let responseParse = await response.json();
    console.log(responseParse);

    // (3) 회원가입이 잘되면 알림창 띄우고 로그인 페이지로 이동한다.
    if (responseParse.code == 1) {
        alert("회원가입완료");
        location.href = "/loginForm";
    } else {
        alert('회원가입실패');
    }
}

// 로그인 요청 함수
async function login() {

    // checkbox의 체크여부를 제이쿼리에서 확인하는 법
    let checked = $('#remember').is(':checked');

    let loginDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        remember: checked ? "on" : "off"
    }

    let response = await fetch("/login", {
        method: "POST",
        body: JSON.stringify(loginDto),
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
        }
    });
    let responseParse = await response.json();
    console.log(responseParse);

    if (responseParse.code == 1) {
        alert("로그인완료");
        location.href = "/";
    } else {
        alert('로그인실패');
    }
}