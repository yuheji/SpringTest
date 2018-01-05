$(document).ready(function() {
    var localhostUrl = "http://localhost:8080/greeting?name=Joshua";
    $.ajax({
        url: localhostUrl
    }).then(function(data, status, jqxhr) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
       console.log(jqxhr);
       console.log(localhostUrl);
    });
});
