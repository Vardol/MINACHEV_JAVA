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
<script>
    function addProduct(name, price) {
        let json = {"name": name, "price": price};

        $.ajax({
            type: "POST",
            url: "/products/ajax",
            data: JSON.stringify(json),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                let resultPlace = document.getElementById('products_table');
                let resultString = '<table>';
                console.clear();
                for (let i = 0; i < response.length; i++) {
                    let current = response[i];
                    resultString += '<tr>';
                    resultString += '<td>';
                    resultString += current['id'] + ' ' + current['name'] + ' ' + current['price'];
                    resultString += '</td>';
                    resultString += '</tr>';
                }
                resultString += '</table>';
                resultPlace.innerHTML = resultString;
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });

    }
</script>
<body>
<div>
<#--<form method="post">-->
<#--<input type="text" name="name" placeholder="Название">-->
<#--<input type="text" name="price" placeholder="Стоимость">-->
<#--<input type="submit" value="Добавить продукт">-->
<#--</form>-->

    <input type="text" id="name" placeholder="Название">
    <input type="text" id="price" placeholder="Стоимость">
    <button onclick="addProduct(document.getElementById('name').value, document.getElementById('price').value)">Добавить продукт</button>
</div>
<div id="products_table">
    <table>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Стоимость</th>
        </tr>
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>