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
    function initialize() {
        $.ajax({
            method: "GET",
            url: '/scheduler.json'
        }).done(function (response) {
            let resultPlace = document.getElementById('result');
            console.clear();
            let resultString = 'Initialized';
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
    <input type="submit" value="Initializr scheduler" onclick="initialize()">
</div>
<div id="result">

</div>
</body>
</html>