# My Weather
Completed project

## [ABOUT/O APLIKACI]

Simple weather aplication for android.

Jednoduchá aplikace pro počasí na android.


## [REQUIRIMENTS/POŽADAVKY]

1.Android OS  
2.Enabled installing application from unknown sources.

1.Android OS  
2.Povolené instalace z neznámých zdrojů.

## [BUGS/CHYBY]

Api from which I'm getting weather information, sometime doesn't have data for specific longitude and latitude 
(which is provided from google maps api), so they send information for Shuzenji (town in Japan).
It's happening because Google Maps and FCC Weather Api have stored different longlat for city.
However, sometimes helps to send the request repeatedly.
The coordinates are correct - google inserts the marker at the specified location, but the FCC Weather data does not match.

Api ze které získávám data o počasí, někdy na get request odpovídá daty pro Shuzenji (město v Japonsku). 
Děje se to proto, že FCC Weather Api a Google Maps mají města uložená pod jinými souřadnicemi. 
A Shouzenji je (pravděpodobně) místo jehož data jsou posílána, když nemají na dotaz odpověď.
Avšak někdy pomůže dotaz poslat opakovaně. 
Souřadnice jsou správné - google vloží marker na určené místo, ale data z FCC Weather neodpovídají.

## [AUTHOR/AUTOR]
Štěpán Drozdek
