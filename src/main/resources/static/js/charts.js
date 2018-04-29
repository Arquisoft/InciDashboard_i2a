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
	
	var values = [
		["Time"]   							
	];
	var initial = 0;
	for(i=0; i<chartIncidents.length; i++){
		if(chartIncidents[i].state === "OPEN"){
			countOpen++;
		}
		else if(chartIncidents[i].state === "CLOSED"){
			countClosed++;
		}
		else if(chartIncidents[i].state === "CANCELLED"){
			countCancelled++;
		}
		else{
			countInProcess++;
		}      							
		
		if(chartIncidents[i].agent.kind === "SENSOR"){
			values[0].push(chartIncidents[i].name);
			var inciTemps = (chartIncidents[i].properties[0])["temp"];
			if(inciTemps != null){
				for(j=0; j<inciTemps.length; j++){
					var tempInfo = inciTemps[j].split("-");
					var time = tempInfo[0];
					var temp = tempInfo[1];
					var index = j + 1;
					if(initial==0){
						values.push([]);
						values[index].push(time);
					}
					values[index].push(parseFloat(temp));
				}    
				initial = 1;
			}      								
		}
	}    						
	
	if(chartIncidents.length > 0){
		document.getElementById("cardPieChart").style.display = "block";
		var data = google.visualization.arrayToDataTable([
          ["Incident State", "Number of chartIncidents"],
          ["OPEN",     		countOpen],
          ["CLOSED",      	countClosed],
          ["CANCELLED",  	countCancelled],
          ["IN_PROCESS", 	countInProcess]
        ]);
		
		var options = {
				title: "State comparison of active chartIncidents",
				is3D: true,
				height: 400
		};
		
		var chart = new google.visualization.PieChart(document.getElementById("piechart"));
		chart.draw(data, options);
	}
	
	if(values.length > 1){
		document.getElementById("cardLineChart").style.display = "block";
		var options = {
				title: "Temperature evolution of chartIncidents submitted by sensors",
				legend: {position: "bottom"},
				height: 400
		};
		
		
		var chart = new google.visualization.LineChart(document.getElementById("linechart"));
		chart.draw(google.visualization.arrayToDataTable(values), options);
	}      						
}