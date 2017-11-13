function uuidv4() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}
if (request.headers['SECRET-KEY'] != 'Ken-Sent-Me'){
    msg = "Key is missing";
    response.status = 400;
}
else if(request.params.username === "admin" && request.params.password === "123456") {
    msg = 'Login OK'
    response.status = 200;
    response.headers['SESSION-ID']=uuidv4();
}
else {
    msg = 'Login Failed';
    response.status = 401;
}
response.body = msg;