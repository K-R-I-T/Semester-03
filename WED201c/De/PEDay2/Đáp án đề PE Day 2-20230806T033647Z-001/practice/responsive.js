onload = function() {
    this.document.getElementById('para2').style.display = 'none';
}

function show() {
    var show = document.getElementById('para2');
    if (show.style.display == 'none') {
        show.style.display = 'block';
        document.getElementById('para3').innerHTML = "SHOW LESS";
    } else {
        show.style.display = 'none';
        document.getElementById('para3').innerHTML = "SHOW ALL";
    }
}

function Enroll() {
    var name = document.getElementById('t1').value;
    var email = document.getElementById('t2').value;
    var password = document.getElementById('t3').value;
    var password2 = document.getElementById('t4').value;

    var check1 = document.getElementById('t5').checked;
    var check2 = document.getElementById('t6').checked;
    var check3 = document.getElementById('t6').checked;
    
    if (name == "" || email == "" || password == "" || password2 == "") {
        alert("Please fill all fields.");
    } else if (password != password2) {
        alert("Password/repassword is invalid.");
    } else if (check1 || check2 || check3) {
        console.log("complete");
        location.reload();
    } else {
        var option = confirm("Would you like to choose options");
        if (option) {
            return;
        } else {
            console.log('Complete');
            location.reload();
        }
    }
}