Feature: Student API

  Scenario: Get all students
    Given I send a GET request to "/students"
    Then the response status code should be 200
    And the response body should contain a list of students

  Scenario: Add a new student
    Given I send a POST request to "/students" with body:
    """
    {
      "firstName": "Emily",
      "lastName": "Clark",
      "age": 23,
      "address": "789 Birch St",
      "city": "Chicago",
      "state": "IL",
      "zipcode": "60611"
    }
    """
    Then the response status code should be 201

  Scenario: Get a student by ID
    Given I send a GET request to "/students/0"
    Then the response status code should be 200
    And the response body should contain:
    """
    {
      "firstName": "John",
      "lastName": "Doe",
      "age": 20
    }
    """