function Showtable() {
    var click = document.getElementById('mydiv');
    if (click.style.display == 'block') {
        document.getElementById('mydiv').style.display = 'none';
    } else {
        document.getElementById('mydiv').style.display = 'block';
    }
}