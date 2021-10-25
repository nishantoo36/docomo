Feature: PostRefundTest

  Scenario:Validate the Response Data of For Post valid uuid for refund
    When user post refund with valid uuid
    Then verify statusCode as 201

  Scenario:Validate the Response Data of For Post invalid uuid for refund
    When user post refund with uuid "test"
    Then verify statusCode as 400

  Scenario:Validate the Response Data of For Post same uuid for refund concurrent
    When user post refund with uuid in parallel
    Then verify statusCode as 423



