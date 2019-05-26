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
            resultPlace.setAttribute('bgcolor', '#46ff27');
        });
    }
</script>
    <div>
        <table>
            <tr>
                <td align="center" width="15%"><a href="?sort=true&by=date&desc=false">По дате (сначала старые)</a></td>
                <td align="center" width="15%"><a href="?sort=true&by=date&desc=true">По дат (сначала новые)</a></td>
                <td align="center" width="50%"></td>
                <td align="center" width="20%"><a href="/collect?range=true">Загрузить последние котировки</a></td>
            </tr>
            <tr>
                <td align="center" ><a href="?sort=true&by=datasource&desc=false">По источнику</a></td>
                <td align="center"><a href="?sort=true&by=datasource&desc=true">По убыванию источника</a></td>
                <td align="center"></td>
                <td align="center"><a href="/collect?range=false">Загрузить последнюю котировку</a></td>
            </tr>
            <tr>
                <td align="center"><a href="?sort=true&by=id&desc=false">По id</a></td>
                <td align="center"><a href="?sort=true&by=id&desc=true">По убыванию id</a></td>
                <td align="center"></td>
                <td align="center"><input type="submit" value="Initialize scheduler" onclick="initialize()"></td>
            </tr>
            <tr>
                <td align="center"><a href="?">Без сортировки</a></td>
                <td align="center"></td>
                <td align="center"></td>
                <td id="result" align="center" bgcolor='#ffffff'></td>
            </tr>
        </table>
    </div>
    <div>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Дата</th>
                <th>Открытие</th>
                <th>Закрытие</th>
                <th>Внутридневной объем</th>
                <th>MAX</th>
                <th>MIN</th>
                <th>Источник</th>
            </tr>
            <#list collectedTechnicalData as TechnicalData>
                <tr>
                    <td>${TechnicalData.id!"no data"}</td>
                    <td>${TechnicalData.date!"no data"}</td>
                    <td>${TechnicalData.openRate!"no data"}</td>
                    <td>${TechnicalData.closeRate!"no data"}</td>
                    <td>${TechnicalData.intradayVolume!"no data"}</td>
                    <td>${TechnicalData.intradayMax!"no data"}</td>
                    <td>${TechnicalData.intradayMin!"no data"}</td>
                    <td>${TechnicalData.dataSource!"no data"}</td>
                </tr>
            </#list>
        </table>
    </div>
</body>
</html>