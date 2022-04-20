/**
 * 
 */



var HOME_PATH = window.HOME_PATH || '.';

var cityhall = new naver.maps.LatLng(36.325117, 127.408829),
    map = new naver.maps.Map('map', {
        center: cityhall.destinationPoint(0, 500),
        zoom: 18
    }),
    marker = new naver.maps.Marker({
        map: map,
        position: cityhall
    });

var infowindow = new naver.maps.InfoWindow({
    content: contentString
});

naver.maps.Event.addListener(marker, "click", function(e) {
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
    }
});

infowindow.open(map, marker);