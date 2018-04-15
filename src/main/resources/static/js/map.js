var mapIncidents = [];
var activeOperator;
var draggable = false;

function initMap(){
	var initialLatLng = {lat: 40.6753526, lng:-6.6971668};
	var map = new google.maps.Map(document.getElementById("mapa"), {
		zoom: 5,  
		center: initialLatLng          
    });		

	var markers = [];
	var infoWindows = [];
	for(i=0; i<mapIncidents.length; i++){
		var inciLocation = {
				lat: parseFloat(mapIncidents[i].location.lat),
				lng: parseFloat(mapIncidents[i].location.lng)
		}
		markers[i] = new google.maps.Marker({
			position: inciLocation,
			title: mapIncidents[i].name,
			draggable: draggable,
			map: map
		});
		
		if(draggable == false){
			markers[i].index = i;
			markers[i].link = "/incident/edit/" + mapIncidents[i].id;

			var contentString = "<div id='content'>" +
				"<h3 id='firstHeading'>" + mapIncidents[i].name + "</h3>" +
				"<div id='bodyContent'>" + 
					"<p>Submitted by: " + mapIncidents[i].agent.username + "</p>" +
					"<p>Agent type: " + mapIncidents[i].agent.kind + "</p>" +
					"<p>State: " + mapIncidents[i].state + "</p>" + 
					"<a href='" +  markers[i].link + "'>Modify incident</a>" +
				"</div>" + 
				"</div>";
				
			infoWindows[i] = new google.maps.InfoWindow({
			    content: contentString
			});
			
			google.maps.event.addListener(markers[i], 'click', function(){
				infoWindows[this.index].open(map, this);
			});					
			
			if(mapIncidents[i].operator.email == activeOperator.email){
				google.maps.event.addListener(markers[i], 'dblclick', function(){
					window.open(this.link, "_self");
				});
			}	
		}						
		else{
			google.maps.event.addListener(markers[i], "dragend", function(event){
				var location = event.latLng.lat() + "," + event.latLng.lng();
				document.getElementById("location").value = location;
			});
		}
	}		
	// Add a marker clusterer to manage the markers.
    var markerCluster = new MarkerClusterer(map, markers,
        {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
}