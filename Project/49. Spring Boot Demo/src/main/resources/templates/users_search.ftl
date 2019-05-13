<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<script>
    function message(query) {
        $.ajax({
            method: "GET",
            url: '/users/search.json?q=' + query
        }).done(function (response) {
            let resultPlace = document.getElementById('result');
            let resultString = '<table>';
            console.clear();
            for (let i = 0; i < response.length; i++) {
                let current = response[i];
                resultString += '<tr>';
                resultString += '<td>';
                resultString += current['firstName'] + ' ' + current['lastName'];
                resultString += '</td>';
                resultString += '</tr>';
            }
            resultString += '</table>';
            resultPlace.innerHTML = resultString;
        });
    }
</script>
<div>
    <input id="query" type="text" placeholder="Запрос" onkeyup="message(document.getElementById('query').value)">
</div>
<div id="result">

</div>
</body>
</html>