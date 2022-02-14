
# Weather Forecast- Automation

An Automated Solution that validates weather information from different
sources and enables a comparison between them.



## Application Layer
Use Selenium- Java to navigate to website https://www.accuweather.com/ 
and on basis of entered city fetched the Temeparture

City Name as search paramter is managed by stag_config.properties file
## ApiLayer
Using Rest-Assured client automated the api end point
that hit the below end point:
api.openweathermap.org/data/2.5

The city query paramter is set in stag_config.properties file


## TempComparator
tempDiffComparator class manages the comparasion of tempeature
from UI and API responses.

class static method:
tempDiffComparator accepts below paramters:
- tempeature from UI
- Response object from API
- tolerance range

Method return boolean flag as true if the tempeature difference between UI and API
is less than tolerance range
else throws exeption
