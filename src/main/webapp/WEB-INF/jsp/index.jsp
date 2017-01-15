<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	Cookie name = new Cookie("name", request.getParameter("name"));
	response.addCookie(name);
%>

<html>
<head>
	<title>WsChat</title>
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script>
		$(function() {
			var ws = new WebSocket("ws://localhost:7001/websocket/wsHandler");
			ws.onopen = function(e) {
				$('#send').click(function() {
					var req = {
						"command": "message",
						"data": {
							"text": $('#data').val()
						}
					};
					ws.send(JSON.stringify(req));
				});
			};
			ws.onmessage = function(e) {
				console.log(e.data);
				$('#response').append(JSON.parse(e.data).text).append('<br/>');
			}
		});
	</script>
</head>
<body>

<h1>Hello <%= request.getParameter("name") %></h1>

<input type="text" id="data">
<button id="send">Send</button>

<div id="response">

</div>

</body>
</html>