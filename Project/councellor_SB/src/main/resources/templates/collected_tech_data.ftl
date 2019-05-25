<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div>
        <a href="?sort=true&by=date&desc=false">По дате</a>
        <a href="?sort=true&by=date&desc=true">По убыванию даты</a>
        <a href="?sort=true&by=datasource&desc=false">По источнику</a>
        <a href="?sort=true&by=datasource&desc=true">По убыванию источника</a>
        <a href="?sort=true&by=id&desc=false">По id</a>
        <a href="?sort=true&by=id&desc=true">По убыванию id</a>
        <a href="?">Все</a>
        <a href="/collect?range=true">Загрузить последние котировки</a>
        <a href="/collect?range=false">Загрузить последнюю котировку</a>
    </div>
    <div>
        <table>
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