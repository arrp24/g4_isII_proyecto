var map, latLng;
		  google.maps.event.addDomListener(window, 'load', function() {
		    map = new google.maps.Map(document.getElementById('map'), {
		      zoom: 6,
		      center: new google.maps.LatLng(-1.229879, -78.290442),
		      mapTypeId: google.maps.MapTypeId.ROADMAP
		    });
		  });

		  function centrar(){
		      
			  	var lon = document.lonlat.longitud.value;
			  	
			  	var lat = document.lonlat.latitud.value;
			  	
			  	var marker1 = new google.maps.Marker({
			  	      map: map,
			  	      position: new google.maps.LatLng(lon, lat)
			  	    });
			  	map.setZoom(16);
			    map.setCenter(marker1.getPosition());
			  	google.maps.event.addListener(marker1, 'click', onMarkerClick);
			  	
		  }