import folium
import pandas
data=pandas.read_csv("Volcanoes.txt")
lat=list(data["LAT"])
lon=list(data["LON"])
elev=list(data["ELEV"]

def color_producer(elevation):
    if elevation <1000:
        return 'green'
    elif 1000<elevavtion<3000:
        return 'orange'
    else:
        return 'red'

m=folium.Map(location=[40.1,80.6],zoom_start=6,tiles="Stamen Toner")
fg=folium.FeatureGroup(name="MyMap")

for la,ln,el in zip(lat,lon,elev):
    fg.add_child(folium.Marker(location=[la,ln],popup=str(el),icon=folium.Icon(color=color_producer(el))))
    fg.add_child()

map.add_child(fg)
m.save("pradeep.html")