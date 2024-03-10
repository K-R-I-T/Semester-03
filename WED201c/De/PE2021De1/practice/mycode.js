function ChangeImg(img, num) {
    var link = img.src;
    if (num == 1) {
        img.src = 'images/miquang02.jpg';
    } else {
        img.src = 'images/spingroll02.jpg';
    }
    
    onmouseout = function() {
        img.src = link
    }
}
