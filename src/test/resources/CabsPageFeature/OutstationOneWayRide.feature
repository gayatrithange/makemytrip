Feature: Cab Booking : Outstation One Way Ride

Scenario: verify OutstationOneWay cab search functionality by selecting cities, time and date
Given URL is launched and login signup popup is closed
And user clicks on cabs tab
When user enters from city as "Pune, Maharashtra, India" and clicks on it from suggestions
And user enters to city as "Mumbai, Maharashtra, India" and clicks on it from suggestions
And User clicks on departure date picker and navigates to next month
And user selects the departure date
And user clicks on pickup time and selects hour, minute and click on apply button
And user captures Parent page title
And clicks on search button
Then user captures Child page title
And user closes browser
And Child page title must be different from Parent page title





