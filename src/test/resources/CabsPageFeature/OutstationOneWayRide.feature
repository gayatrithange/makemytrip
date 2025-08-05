Feature: Cab Booking : Outstation One Way Ride

@Second
Scenario: verify OutstationOneWay cab search functionality by selecting cities, time and date
Given user clicks on cabs tab
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

@Today
Scenario: verify error message after entering same From and To input fields
Given user clicks on cabs tab
When user enters from city as "Pune, Maharashtra, India" and clicks on it from suggestions
And user enters to city as "Pune, Maharashtra, India" and clicks on it from suggestions
Then verify error message displayed below To input text box

@Third
Scenario: verify Error Message appear and shakes after entering same From and To City and click on search
Given user clicks on cabs tab
When user enters from city as "Pune, Maharashtra, India" and clicks on it from suggestions
And user enters to city as "Pune, Maharashtra, India" and clicks on it from suggestions
Then clicks on search button
And verify error message shakes

@Today
Scenario: verify By clicking on Return Date of Outstation One-Way ride type shifts to Outstation Round-Trip
Given user clicks on cabs tab
When user clicks on return date of Ontstation One-way
Then ride type shifts to Outstation Round-Trip


