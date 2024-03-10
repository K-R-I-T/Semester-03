function show() {
    var click = document.getElementById('para2');

    if (click.style.display == "block") {
        click.style.display = "none";
        document.getElementById('para3').innerHTML = "SHOW ALL";
    } else {
        click.style.display = "block";
        document.getElementById('para3').innerHTML = "SHOW LESS";
    }
}

function Enroll() {
    var name = document.getElementById('t1').value;
    var email = document.getElementById('t2').value;
    var pass = document.getElementById('t3').value;
    var repass = document.getElementById('t4').value;

    var aws1 = document.getElementById('t5').checked;
    var aws2 = document.getElementById('t6').checked;
    var aws3 = document.getElementById('t7').checked;

    if (name == '' || email == '' || pass == '' || repass == '') {
        alert('Please fill all fields.');
    } else if (pass != repass) {
        alert('Password/repassword is invalid.')
    } else if (aws1 || aws2 || aws3) {
        console.log('Complete');
    } else {
        var option = confirm("Would you like to choose options");
        if (option) {

        } else {
            alert('Start learning WED201c');
        }
    }

}