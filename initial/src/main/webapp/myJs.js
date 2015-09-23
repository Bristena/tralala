window.onload = function(e){



    function loadJSON() {
        var data_file = "http://localhost:8080/animals/";
        var http_request = new XMLHttpRequest();
        http_request.onreadystatechange = function () {
            if (http_request.readyState == 4) {
                var jsonObj = JSON.parse(http_request.responseText);
                var data = JSON.stringify(jsonObj);
                jsonObj.map(function (item) {
                    var comment = item.id;
                    var newParagraph = document.createElement('p');
                    newParagraph.textContent = comment;
                    document.getElementById("div").appendChild(newParagraph);
                    var comment1 = item.denumire;
                    var newParagraph1 = document.createElement('p1');
                    newParagraph1.textContent = comment1;
                    document.getElementById("div").appendChild(newParagraph1);
                });
                if (http_request.status == 410) {
                    alert("status 410");
                }
            }
        }

        http_request.open("GET", data_file, true);
        http_request.send();
    }

    function cauta() {
        alert("nu face nimic");
        var id = document.getElementById("idA");
        var data_file = "http://localhost:8080/animals/" + id.value;
        var http_request = new XMLHttpRequest();
        // Opera 8.0+, Firefox, Chrome, Safari
        http_request = new XMLHttpRequest();

        http_request.onreadystatechange = function () {
            alert("ok");
        }

        http_request.open("GET", data_file, true);
        http_request.send();
    }

    function myFunction() {
        alert("tralalal");
    }

}

function cauta() {
    var id = document.getElementById("idA");
    var data_file = "http://localhost:8080/animals/" + id.value;
    var http_request = new XMLHttpRequest();
    // Opera 8.0+, Firefox, Chrome, Safari
    http_request = new XMLHttpRequest();

    http_request.onreadystatechange = function () {
        this.response;
    }

    http_request.open("GET", data_file, true);
    http_request.send();
}
