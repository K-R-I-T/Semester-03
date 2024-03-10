function zoomout(img) {
    var link = img.src;

    document.getElementById('frame').style.backgroundImage = 'url(' + link + ')';
    document.getElementById('frame').style.backgroundRepeat = 'no-repeat';
    document.getElementById('frame').style.backgroundSize = '300px 300px';

}

function warning() {
    var name = document.getElementById('yourname').value;
    var email = document.getElementById('email').value;
    var content = document.getElementById('content').value;

    if (name == '' || email == '' || content == '') {
        alert('please fill all field');
    } else {
        var option = confirm('mess sent');
        if (option) {
            document.getElementById('yourname').value = '';
            document.getElementById('email').value = '';
            document.getElementById('content').value = '';
        }
    }
}