function addIncidentToTable(incident){
	alert(incident.location.toString());
	$("#tableBody").append(
		"<tr>"
		+ "<td>" + incident.agent.username + "<td>"
		+ "<td>" + incident.agent.kind.toString() + "<td>"
		+ "<td>" + incident.name + "<td>"
		+ "<td>LatLng[lat=" + incident.location.lat + ",lng=" + incident.location.lng + "]<td>"
		+ "<td>" + incident.state.toString() + "<td>"
		+ "<td>" + incident.properties.toString() + "<td>"
		+ "<td>" + incident.operator.email + "<td>"
		+ "<td>" + incident.comments.toString() + "<td>"
	);
	
	if(incident.operator.email == activeOperator.email){
		$("#tableBody").append(
		"<div>"
		+ "<td><a class='btn btn-primary' role='button' href='/incident/edit/" + incident.id + "'>Modify</a></td></tr>"
		);
	}
}