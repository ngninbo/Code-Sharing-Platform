function send() {
    const time = Number(document.getElementById("time_restriction").value)
    const views = Number(document.getElementById("views_restriction").value)
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": time < 0 ? 0 : time,
        "views": views < 0 ? 0 : views
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status == 200) {
      alert("Success!");
    }
}
