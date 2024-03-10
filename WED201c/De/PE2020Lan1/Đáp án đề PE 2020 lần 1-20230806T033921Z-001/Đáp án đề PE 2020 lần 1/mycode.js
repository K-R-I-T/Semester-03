function checkInput() {
    var name = document.getElementsByTagName('input')[0].value;
    var email = document.getElementsByTagName('input')[1].value;
    var content = document.getElementsByTagName('textarea')[0].value;
    var university = document.getElementsByTagName('select')[0].value;

    var message = "Đừng để trống: ";
    if (name == "" && email == "" && content == "") {
        alert(message + "tên, email, nội dung");
        return;
    }
    if (name == "") {
        alert(message + "tên");
        return;
    }
    if (email == "") {
        alert(message + "email");
        return;
    }
    if (content == "") {
        alert(message + "nội dung");
        return;
    }

    var mywindow = window.open("", "", "width= 300px, height= 300px");
    mywindow.document.write("<h1>Vui lòng xem lại: </h1>");
    mywindow.document.write("<h2>Tên của bạn:" + name + "</h2>");
    mywindow.document.write("<h2>Email của bạn:" + email + "</h2>");
    mywindow.document.write("<h2>Nd của bạn:" + content + "</h2>");
    mywindow.document.write("<h2>University của bạn:" + university + "</h2>");
}