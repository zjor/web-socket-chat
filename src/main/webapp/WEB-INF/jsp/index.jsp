<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>WsChat</title>
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script>
		$(function() {
			var ws = new WebSocket("ws://localhost:7001/websocket/wsHandler");
			ws.onopen = function(e) {
				$('#send').click(function() {
					ws.send($('#data').val());
				});
			};
			ws.onmessage = function(e) {
				$('#response').append(e.data).append('<br/>');
			}
		});

	</script>
</head>
<body>

<input type="text" id="data">
<button id="send">Send</button>

<div id="response">

</div>

</body>
</html>