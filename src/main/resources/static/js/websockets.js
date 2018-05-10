function connect(){
	var socket = new SockJS("/dashboard");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){		
		console.log("Connected: " + frame);

		stompClient.subscribe("/incident", function (data) {			
			var incident = JSON.parse(data.body);
	        mapIncidents.push(incident);
	        chartIncidents.push(incident);
	        initMap();
	        updateCharts();  
	        updateTable();
		});		
	});
}

$(document).ready(function () {
    connect();
});