// get the http module:
var http = require('http');
// fs module allows us to read and write content for responses!!
var fs = require('fs');

var url = require('url');

// creating a server using http module:
var server = http.createServer(function (request, response){
    // see what URL the clients are requesting:
    console.log('client request URL: ', request.url);

    var url_parts = url.parse(request.url, true);
    var query = url_parts.query;
    console.log(url_parts);
    // this is how we do routing:
    if(request.url === '/') {
        fs.readFile('views/index.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.write(contents); 
            response.end();
        });
    }
    else if (request.url === "/cars") {
         fs.readFile('views/cars.html', 'utf8', function (errors, contents){
             response.writeHead(200, {'Content-type': 'text/html'});
             response.write(contents); 
             response.end();
         });
    }
    else if (request.url === "/cats") {
         fs.readFile('views/cats.html', 'utf8', function (errors, contents){
             response.writeHead(200, {'Content-type': 'text/html'});
             response.write(contents); 
             response.end();
         });
    }
    else if(request.url === "/images/img1.jpeg") {
        fs.readFile('images/img1.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img2.jpeg") {
        fs.readFile('images/img2.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img3.jpeg") {
        fs.readFile('images/img3.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img4.jpeg") {
        fs.readFile('images/img4.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img5.jpeg") {
        fs.readFile('images/img5.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
            response.write(contents);
            response.end();
        });
    }
    else if(request.url === "/images/img6.jpeg") {
        fs.readFile('images/img6.jpeg', function(errors, contents){
            response.writeHead(200, {'Content-Type': 'image/jpeg'});
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
server.listen(7077);
// print to terminal window
console.log("Running in localhost at port 7077");
