function check() {
    var arr = document.getElementsByTagName('input');

    var email = arr[0].value;
    var c1 = arr[1].checked;
    var c2 = arr[2].checked;
    var c3 = arr[3].checked;
    var content = arr[4].value;

    if (email == '') {
        alert('email must not be empty');
    } else if (!c1 && !c2 && !c3) {
        alert('radio must be checked');
    } else if (content == '') {
        alert('content must not be empty');
    } else {
        alert('send mess successfully');
    }
}

function changeImg(img) {
    var address = img.src;
    document.getElementById('bigImg').style.backgroundImage = 'url(' + address + ')';
}