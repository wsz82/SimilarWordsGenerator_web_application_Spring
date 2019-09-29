<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Similar Words Generator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<ul style="list-style-type:none;">
<#list model["words"] as word>
    <li>${word}</li>
</#list>
</ul>
</body>
</html>