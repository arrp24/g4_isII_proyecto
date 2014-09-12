window.onload = function() {

	document.getElementById('frmBuscador:lonlat:btnBuscar').onclick = function() {
		elemento = document.getElementById('frmBuscador:lonlat:btnBuscar');
		elemento.disable = true;
		document.getElementById('divEspere').style.visibility = 'visible';
	};	
}