// get the http module:
var http = require('http');
// fs module allows us to read and write content for responses!!
var fs = require('fs');
// creating a server using http module:
var server = http.createServer(function (request, response){
    // see what URL the clients are requesting:
    console.log('client request URL: ', request.url);
    // this is how we do routing:
    if(request.url === '/') {
        fs.readFile('index.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.write(contents); 
            response.end();
        });
    }
    else if (request.url === "/dojo.html") {
         fs.readFile('dojo.html', 'utf8', function (errors, contents){
             response.writeHead(200, {'Content-type': 'text/html'});
             response.write(contents); 
             response.end();
         });
    }
    else if(request.url === "/stylesheets/style.css") {
        fs.readFile('stylesheets/style.css', 'utf8', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'text/css'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/js/myJS.js") {
        fs.readFile('js/myJS.js', 'utf8', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'text/javascript'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img.png") {
        fs.readFile('images/img.png', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/png'});
            response.write(contents);
            response.end();
        });
    }
    // request didn't match anything:
    else {
        response.end('File not found!!!');
    }
});
// tell your server which port to run on
server.listen(6789);
// print to terminal window
console.log("Running in localhost at port 6789");
