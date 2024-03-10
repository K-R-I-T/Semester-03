function changeImg(img) {
    var src = img.src;
    document.getElementById('bigImg').style.backgroundImage = "url(" + src + ")";
}

function check() {
    var email = document.getElementsByTagName('input')[0].value;
    var choice = document.getElementsByTagName('input')[1];
    var content = document.getElementsByTagName('textarea')[0].value;

    if (email == "" || !choice.checked || content == "") {
        alert("Đừng để trống");
    } else {
        if (confirm("Tin nhắn được gửi thành công")) {
            document.getElementsByTagName('input')[0].value = "";
            document.getElementsByTagName('input')[1].checked = false;
            document.getElementsByTagName('textarea')[0].value = "";
        }
    }
}