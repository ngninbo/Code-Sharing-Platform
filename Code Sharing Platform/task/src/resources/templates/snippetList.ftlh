<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link type="text/css" rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" target="_blank"
        href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list snippets as snippet>
<div>
<span id="load_date">${snippet.date}</span>
<pre id="code_snippet"><code>${snippet.code}</code></pre>
</div>
</#list>
</body>
</html>