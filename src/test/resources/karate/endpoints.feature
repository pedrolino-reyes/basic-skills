Feature: Basic tests

  Background:
    * url baseUrl

  Scenario: Hit the root endpoint
    * method get
    * status 200
    * match response == "This is the API root"

  Scenario: Hit the calculator endpoint
    * path 'calculator'
    * method get
    * status 200
    * match response == "This is the calculator"