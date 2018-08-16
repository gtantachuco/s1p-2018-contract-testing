# Contract Testing with Spring Cloud Contract

I am pretty sure your company/organization has many existing services that provide business functionality to customers, internal users and/or partners.
In our example, this __Person__ service provides people information to both new and legacy systems via __HTTP__ and __asynchronous messaging__

![The System](TheSystem.png)

## The Challenge: Service evolution
In order for you to keep up with market conditions, new regulations and the competition, you need to make schema changes and/or functionality changes to said services.
The question is: __How do you do that without impacting your existing consumers?__

## The Solution: Consumer-driven contracts
__Consumer-driven contracts__ allow you to test integration points between services providers and its consumers without setting up the whole runtime environment. Based on a common API contract, it runs isolated tests between the consumer and a mock provider; and, between a mock consumer and the real provider.

## The Tool: Spring Cloud Contract


## Pre-requisites

## Getting started
Run Person Service
Run Client app

## Scenario 1: Happy path

## Scenario 2: Change REST endpoint of the Person service's _Find By ID_ method

## Scenario 3: Change name of Person's _last name_ field

## Scenario 4: CI/CD with Concourse
Our goal is to fail the build of the application when there is faulty integration, so together with unit and integration tests, contract tests should have a place in the testing pyramid.
![Test Pyramid](testing_pyramid.png)

## Scenario 5: Developing with Atomist

## Who should use consumer-drive contracts?
This pattern is applicable in the context of either a single enterprise or a closed community of well-know services where providers have some influence over how consumers establish contracts with them.


# Resources
REST and Async messaging example: <Marcin github repo: https://github.com/marcingrzejszczak/sc-contract-car-rental>
