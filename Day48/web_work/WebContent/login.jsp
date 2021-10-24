<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="./login.css" type="text/css" media="all" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <div id="container" class="main_container">
        <div style="padding: 20px;"></div>
        <div class="login_container">
            <div class="form_container">
                <form name="login_form" action="/cookie" method="get">
                    <div class="form_title_div">
                        <p class="form_title_p">Register With Us</p>
                    </div>
                    <div>
                        <div>
                            <a class="form_item_name">username</a>
                        </div>
                        <div>
                            <input type="text" name="username" placeholder="name" class="form_input"/>
                        </div>
                        <div class="form_text_alert_padding">
                            <div id="alert_username" class="form_text_alert"></div>
                        </div>
                    </div>
                    <div>
                        <div>
                            <a class="form_item_name">Email</a>
                        </div>
                        <div>
                            <input type="text" name="email" placeholder="E-mail" class="form_input"/>
                        </div>
                        <div class="form_text_alert_padding">
                            <div id="alert_email" class="form_text_alert"></div>
                        </div>
                    </div>
                    <div>
                        <div>
                            <a class="form_item_name">Password</a>
                        </div>
                        <div>
                            <input type="password" name="password" placeholder="Enter password" class="form_input" />
                        </div>
                        <div class="form_text_alert_padding">
                            <div id="alert_password" class="form_text_alert"></div>
                        </div>
                    </div>
                    <div>
                        <div>
                            <a class="form_item_name">Confirm Password</a>
                        </div>
                        <div>
                            <input type="password" name="password2" onfocus="" placeholder="Enter password again" class="form_input" />
                        </div>
                        <div class="form_text_alert_padding">
                            <div id="alert_password2" class="form_text_alert"></div>
                        </div>
                    </div>
                    <div style="height: 10px;"></div>
                    <div>
                        <button type="button" class="form_submit_button" onclick="login()">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
function login() {
    const form = document.login_form;
    const chkUsername = checkValidUsername(form);
    const chkEmail = checkValidEmail(form);
    const chkPw = checkValidPassword(form);
    const chkPw2 = checkValidPassword2(form);

    if (chkUsername) {
        document.getElementById('alert_username').innerText = "";
        form.username.style.border = '2px solid';
        form.username.style.borderColor = '#00D000';
    } else {
        form.username.style.border = '2px solid';
        form.username.style.borderColor = '#FF0000';
        document.getElementById('alert_username').style.color = '#FF0000';
    }

    if (chkEmail) {
        document.getElementById('alert_email').innerText = "";
        form.email.style.border = '2px solid';
        form.email.style.borderColor = '#00D000';
    } else {
        form.email.style.border = '2px solid';
        form.email.style.borderColor = '#FF0000';
        document.getElementById('alert_email').style.color = '#FF0000';
    }

    if (chkPw) {
        document.getElementById('alert_password').innerText = "";
        form.password.style.border = '2px solid';
        form.password.style.borderColor = '#00D000';
    } else {
        form.password.style.border = '2px solid';
        form.password.style.borderColor = '#FF0000';
        document.getElementById('alert_password').style.color = '#FF0000';
    }
    if (chkPw2) {
        document.getElementById('alert_password2').innerText = "";
        form.password2.style.border = '2px solid';
        form.password2.style.borderColor = '#00D000';
    } else {
        form.password2.style.border = '2px solid';
        form.password2.style.borderColor = '#FF0000';
        document.getElementById('alert_password2').style.color = '#FF0000';
    }

    if (chkUsername && chkEmail && chkPw && chkPw2) {
        console.log('complete. form.submit();');
    }
}

function checkValidUsername(form) {
    if (form.username.value == "") {
        document.getElementById('alert_username').innerText = "Please enter username.";

        return false;
    }

    return true;
}

function checkValidEmail(form) {
    if (form.email.value == "") {
        document.getElementById('alert_email').innerText = "Please enter email.";
        return false;
    }

    const exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

    // 이메일 형식 검사.
    if (exptext.test(form.email.value) === false) {
        document.getElementById('alert_email').innerText = "Email is not valid.";

        return false;
    }

    return true;
}

function checkValidPassword(form) {
    if (form.password.value == "") {
        document.getElementById('alert_password').innerText = "Please enter password.";
        //form.password.focus();
        return false;
    }

    const pw = form.password.value;
    // String.prototype.search() :: 검색된 문자열 중에 첫 번째로 매치되는 것의 인덱스를 반환한다. 찾지 못하면 -1 을 반환한다.
    // number
    const num = pw.search(/[0-9]/g);
    // alphabet
    const eng = pw.search(/[a-z]/ig);
    // special characters
    const spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if (pw.length < 6) {
        // 6문자이상 설정
        document.getElementById('alert_password').innerText = "Password must be at least 6 characters.";
        return false;
    } else if (pw.search(/\s/) != -1) {
        // 공밲 없앰
        document.getElementById('alert_password').innerText = "Please enter your password without spaces.";
        return false;
    } else if (num < 0 && eng < 0 && spe < 0) {
        // 문자열 입력 방지
        document.getElementById('alert_password').innerText = "Password is not valid.";
        return false;
    }

    return true;
}

function checkValidPassword2(form) {
    if (form.password2.value == "") {
        document.getElementById('alert_password2').innerText = "Password2 is required.";
        return false;
    }

    if (form.password.value !== form.password2.value) {
        document.getElementById('alert_password2').innerText = "Password and password2 is not match.";
        form.password.style.border = '2px solid';
        form.password.style.borderColor = '#FF0000';
        document.getElementById('alert_password').style.color = '#FF0000';
        return false;
    }

    return true;
}
</script>
</html>

