Feature: Validating GoogleMaps AddPlace and DeletePlace API's

@AddPlace
Scenario Outline: Verify the functionality of AddPlace API

Given AddPlace Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And verify created placeId to "<name>" using "<GetPlaceAPI>"

Examples:
 |name|language|address|
 |Amberville|French|Englad|

@DeletePlace
Scenario: Verify the functionality of DeletePlace API

Given DeletePlace Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
