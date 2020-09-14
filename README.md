# roadmap
###################################
### Project Name: roadmap
###################################
This is a RESTful service using spring boot. Primary objective of this web service is to find if 2 cities are connected or not.
In case of cities are connected then a yes or no answer will be responded back by the service along with input provided (i.e., origin & destination city).
Both origin & destination are responded back so that the client implementation can be more state less.

2 API calls have been exposed from this service.

1. GET - Expects 2 city names as Request Parameters along with the host, port & end point (i.e., /connected).
	Example:
		url: http://localhost:9191/connected/origin=Boston&destination=New York
		Response Payoad: (In case CONNECTED)
			{
				"origin": "Boston",
				"destination": "New York",
				"connected": "yes"
			}
		Response Paylaod: (In case NOT CONNECTED):
			{
				"origin": "Boston",
				"destination": "New Yorked",
				"connected": "no"
			}

2. POST - Expects 2 city names as part of request payload.
(Since POST is more secure call, hence this can be used for any future enhancements).
	Example:
		url: http://localhost:919/connected
		Request Payload:
			{
				"origin": "Boston",
				"destination": "New York"
			}
		Response Payload (In Case connected):
			{
				"origin": "Boston",
				"destination": "New York",
				"connected": "yes"
			}

		Response Payload (In case NOT connected):
			{
				"origin": "Boston",
				"destination": "New Yorke",
				"connected": "yes"
			}
Note: Postman collections have also been attached to this project in src/test/resources for testing.

###################################
### Pre-requisites
###################################
1. Java 11
2. STS or IntelliJ
3. Maven (latest version preferable)
4. Postman (to test the collections) - To see the service in running.

###################################
### To import the project
###################################
1. cd to the project you wish to install the project.
2. Import the project directory to your work space on intelliJ or STS (i.e., Eclipse) as per the versions.
3. Right click on the project and run as spring boot application.
Note: By default the application will run on 9191 as per the prot number provided in application.properties.


###################################
### To build the project
###################################
1. Build - Since this is a maven based project, after import to the current workspace. Right click on the project and click on build with (clean install).
	or use mvn clean install command from cmd prompt.
2. Run - Right click on the project and run as spring boot project.


###################################
### Design & Implementation details
###################################
1. Built using MVC architecture based.
2. A cache like approach is considered here instead of a database (H2). In this case the "RoadMapCache" will act as cache with handler RoadMapCacheHandler which will provide handle on the cache.
3. RoadMapService will have access to this cache handle to extract the connections between cities.
4. Even though city.txt is in tuple kind of structure (City, City), cache has a structure of HashMap<City, HashSet<City>>. With this approach getting the response will be faster in O(1).
 
###################################
### Limitations (should be fixed in later version)
###################################
1. Cache may have duplicates if the city.txt has duplicates
Example:
	If City.txt has
		Boston, Secaucus
		Boston, Newark
		Secaucus, Boston
	then cache will have
		[Boston, [(Secaucus, Newark)] as one entry and
		[Secaucus, [(Boston)] as another entry.

2. In case the list of the cities connected grows a database approach can be used with hibernate as ORM tool which has inbuilt caching mechanism which will help to enhance the project.

3. Currently only ", " is considered as separator which should be changed to that it supports both "," and ", ".
4. Since streams are being used during the initialization of the cache during boot strap, adding any additional splitters is easier in the mapping part. 
