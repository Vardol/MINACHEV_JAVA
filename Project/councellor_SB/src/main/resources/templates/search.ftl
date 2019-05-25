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
    function search(query) {
        $.ajax({
            method: "GET",
            url: '/search.json?q=' + query
        }).done(function (response) {
            let resultPlace = document.getElementById('result');
            console.clear();
            let resultString = '<table>';
            for (let i = 0; i < response.length; i++) {
                let current = response[i];
                resultString += '<tr>';
                resultString += '<td>';
                resultString += current['date'];
                resultString += '</td>';
                resultString += '<td>';
                resultString += 'open=' + current['openRate'];
                resultString += '</td>';
                resultString += '<td>';
                resultString += 'close=' + current['closeRate'];
                resultString += '</td>';
                resultString += '<td>';
                resultString += 'MAX=' + current['intradayMax'];
                resultString += '</td>';
                resultString += '<td>';
                resultString += 'MIN=' + current['intradayMin'];
                resultString += '</td>';
                // resultString += '<td>';
                // resultString += 'Volume=' + current['intradayVolume'];
                // resultString += '</td>';
                resultString += '<td>';
                resultString += 'source=' + current['dataSource'];
                resultString += '</td>';
                resultString += '</tr>';
            }
            resultString += '</table>';
            resultPlace.innerHTML = resultString;
        });
    }
</script>
<#--<div>-->
<#--    <form method="post">-->
<#--        <input id="query" type="text" placeholder="дата в формате yyyy-mm-dd">-->
<#--        <br>-->
<#--        <input type="submit" value="поиск по дате" onclick="search(document.getElementById('query').value)">-->
<#--    </form>-->
<#--</div>-->
<div>
    <input id="query" type="text" placeholder="источник" onsubmit="search(document.getElementById('query').value)">
    <br>
    <input type="submit" value="поиск по источнику" onclick="search(document.getElementById('query').value)">
</div>
<div id="result">

</div>
</body>
</html>