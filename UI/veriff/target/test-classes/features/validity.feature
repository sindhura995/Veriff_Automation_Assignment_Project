Feature: Veriff Application Login

Scenario Outline: To check whether user is successfully navigated to home page
		 Given User selects a "<Language>" "<Country>" "<Document_type>" "<Launch_type>" from respective dropdowns
		 When If the selected document is valid
		 Then the user is navigated to veriff's Home page
Examples:
	| Language	 | Country    |Document_type    | Launch_type   |
#	| English    | India      |Passport         | InContext     |Positive test case
#	| Spanish    | Albania    |Driver's License | Redirect      |POsitive test case        
#	| English    | Afghanistan|Residence Permit | InContext     | Negative test case
