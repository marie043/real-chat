var express = require('express');
var fs = require('fs');
var readLine = require('readline');
var app = express();
app.use(express.json());
app.use(express.urlencoded({extends:true}));
app.get('/',function(req,res){
	var chatlsit = fs.readFileSync(__dirname+'/log.txt','utf8');
	var content = '';
	var tempContent = fs.readFileSync(__dirname+'/home.html','utf8').split("\n");
	for(var i=0;i<10;i++){
		content += tempContent[i];
	}
	content += chatlsit;
	for(var i=10;i<32;i++){
		content += tempContent[i];
	}
	res.send(content);
});
app.post('/',function(req,res){
	var logFile = fs.openSync(__dirname+'/log.txt','a');
	fs.appendFileSync(logFile,"<p>"+req.body.message+"</P>\n",'utf8');
	fs.closeSync(logFile);
	var chatlsit = fs.readFileSync(__dirname+'/log.txt','utf8');
	var content = '';
	var tempContent = fs.readFileSync(__dirname+'/home.html','utf8').split("\n");
	for(var i=0;i<10;i++){
		content += tempContent[i];
	}
	content += chatlsit;
	for(var i=10;i<32;i++){
		content += tempContent[i];
	}
	res.send(content);
});
app.listen(8080,function(){
	console.log("listen 8080port!");
});