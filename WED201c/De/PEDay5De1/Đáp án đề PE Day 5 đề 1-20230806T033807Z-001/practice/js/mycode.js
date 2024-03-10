onload = function() {
    this.document.getElementById('myform').style.display = 'none';
    this.document.getElementById('team').style.display = 'none';
}

function show() {
    var show = document.getElementById('showmore');
    var table = document.getElementById('team');
    if (table.style.display == 'block') {
        show.innerHTML = "SHOW MORE";
        table.style.display = 'none';
        document.getElementById('myform').style.display = 'none';
    } else {
        show.innerHTML = "SHOW LESS";
        table.style.display = 'block';
        document.getElementById('myform').style.display = 'block';
    }
}

function check() {
    var email = document.getElementById('email').value;
    var usa = document.getElementById('USA');
    var uk = document.getElementById('UK');
    var captcha = document.getElementsByTagName('input')[3].value;

    if (email == "") {
        alert("please fill your email");
    } else if (!usa.checked && !uk.checked) {
        alert("please check your options");
    } else if (captcha != "cVr12TY") {
        alert("please check your capchar");
    } else {
        var option = confirm("thank you very much");
        if (option) {
            location.reload();
        }
    }
}