var chartIncidents = [];

function updateCharts(){
	google.charts.load("current", {"packages":["corechart"]});
	google.charts.setOnLoadCallback(drawCharts);
}

function drawCharts(){
	var countOpen = 0;
	var countClosed = 0;
	var countCancelled = 0;
	var countInProcess = 0;
	
	var countPerson = 0;
	var countEntity = 0;
	var countSensor = 0;

	for(i=0; i<chartIncidents.length; i++){
		if(chartIncidents[i].state === "OPEN"){
			countOpen++;
		}
		if(chartIncidents[i].state === "CLOSED"){
			countClosed++;
		}
		if(chartIncidents[i].state === "CANCELLED"){
			countCancelled++;
		}
		if(chartIncidents[i].state === "INPROCESS"){
			countInProcess++;
		}    	
		
		if(chartIncidents[i].kindCode === "PERSON"){
			countPerson++;
		}
		if(chartIncidents[i].kindCode === "ENTITY"){
			countEntity++;
		}
		if(chartIncidents[i].kindCode === "SENSOR"){
			countSensor++;
		}
	}    						
	
	if(chartIncidents.length > 0){
		document.getElementById("cardPieChart").style.display = "block";
		var pieData = google.visualization.arrayToDataTable([
          ["Incident State", "Number of incidents"],
          ["OPEN",     		countOpen],
          ["CLOSED",      	countClosed],
          ["CANCELLED",  	countCancelled],
          ["IN_PROCESS", 	countInProcess]
        ]);
		
		var pieOptions = {
				is3D: true,
				height: 400
		};
		
		var pieChart = new google.visualization.PieChart(document.getElementById("piechart"));
		pieChart.draw(pieData, pieOptions);
		
		
		document.getElementById("cardColumnChart").style.display = "block";
		var columnData = google.visualization.arrayToDataTable([
	          ["Agent kind", "Number of incidents"],
	          ["PERSON",     	countPerson],
	          ["ENTITY",      	countEntity],
	          ["SENSOR",  		countSensor]
		]);
		
		var columnOptions = {
				height: 400
		};
		
		var columnChart = new google.visualization.ColumnChart(document.getElementById("columnchart"));
		columnChart.draw(columnData, columnOptions);
	}   						
}