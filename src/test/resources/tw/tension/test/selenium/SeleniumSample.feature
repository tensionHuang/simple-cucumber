Feature: Use selenium to interact with Google website

  Scenario: Submit search keyword 'marvel' to google and check the title of page
    Given Create a Firefox driver and connect to Google website
    When Input the keyword 'marvel' and submit
    Then Get the title of returned page which is 'marvel'