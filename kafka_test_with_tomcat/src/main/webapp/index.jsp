<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>REAL CHAT</title>
</head>
<body>
<h1>Real-Chat</h1>
	<div id="chat_list">
	</div>
	<form id="chat_input" method="post" action="/">
		<input type="text" name="message" id="message" maxlength="30" size="15">
		<input type="submit" onclick="sendMessage()" name="send" id="send" value="send">
	</form>
	<div id="chat_result">
		<h3>Real-Chat Ranking</h3>
		<li id="rank1">rank1</li>
		<li id="rank2">rank2</li>
		<li id="rank3">rank3</li>
		<li id="rank4">rank4</li>
		<li id="rank5">rank5</li>
</body>
</html>