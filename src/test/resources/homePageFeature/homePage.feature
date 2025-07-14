Feature: This feature file tests home features

Scenario: verify Arrival for searched trains.
Given: login popup is closed
When:  user enters from city as Mumbai
And:   user enters to city as goa
And:   click on search trains button
When:  search result page loads ,user clicks on arrival before 12 pm checkbox
Then:  All trains which has arrival before 12 pm should appear.

