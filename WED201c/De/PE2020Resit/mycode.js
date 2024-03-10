function checkInput() {
    var name = document.getElementsByTagName('input')[0].value;
    var email = document.getElementsByTagName('input')[1].value;
    var year = document.getElementsByTagName('select')[0].value;
    var toan = document.getElementsByTagName('select')[1].value;
    var ly = document.getElementsByTagName('select')[2].value;
    var nn = document.getElementsByTagName('select')[3].value;
    var check1 = document.getElementsByTagName('input')[2];
    var check2 = document.getElementsByTagName('input')[3];
    var check3 = document.getElementsByTagName('input')[4];
    if (name == "" || email == "") {
        alert("Đừng để trống tên và email của bạn");
        return;
    }
    var show = "Xem lại thông tin của bạn";
    show += "\nTên: " + name;
    show += "\nEmail: " + email;
    show += "\nĐiểm toán: " + toan;
    show += "\nĐiểm lý: " + ly;
    show += "\nĐiểm ngoại ngữ: " + nn;
    show += "\nKỹ năng:";
    if (check1.checked) {
        show += "\nTư duy logic tốt";
    }
    if (check2.checked) {
        show += "\nCó khiếu thẩm mỹ";
    }
    if (check3.checked) {
        show += "\nNhạy bén, nắm bắt tốt với các cơ hội";
    }
    document.getElementById('show').value = show;
    document.getElementById('show').style.display = "block";

}