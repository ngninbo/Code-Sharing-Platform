<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link type="text/css" rel="stylesheet" href="../../css/style.css">
    <script type="text/javascript" src="../../js/upload.js"></script>
</head>
<body>
<form>
    <div>
        <textarea id="code_snippet" rows="10">// write your code here</textarea>
    </div>
    <p>
        <label for="time_restriction">Time restriction</label>
        <input id="time_restriction" type="text"></input>
    </p>
    <p>
         <label for="views_restriction">Views restriction</label>
         <input id="views_restriction" type="text"></input>
    </p>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
</body>
</html>