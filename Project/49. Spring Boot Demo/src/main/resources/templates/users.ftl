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
    <a href="?sort=true&by=age">По возрастанию возраста</a>
    <a href="?sort=true&by=id">По возрастанию id</a>
    <a href="?sort=true&by=age&desc=true">По убыванию возраста</a>
    <a href="?sort=true&by=id&desc=true">По убыванию id</a>
    <a href="?">Все</a>
</div>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
        </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>