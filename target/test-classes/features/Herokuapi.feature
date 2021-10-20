Feature: Herokuapi testing for CRUID operators

  Background:
    Given user given api url "https://restful-booker.herokuapp.com/"

  Scenario Outline: POST - Create a new user
    Given set api endpoint "booking/8"
    And User creates new user with request body "<firstname>","<lastname>","<totalprice>","<depositpaid>",<"checkin">
    Then validate the status code 201
    And validate the firstname is "<firstname>"
    And validate the lastname is "<lastname>"
    And validate the totalprice is "<totalprice>"
    And validate the depositpaid is "<depositpaid>"
    And valide the checkin is "<checkin>"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin |
      | Orcun     | Jackson  | 1000       | false       | 2015-11-05 |
    