# Pre-requisites
In order to complete this lab, you will need to install the following software in your computer:
1) [Spring Tool Suite](https://spring.io/tools) or your preferred Java/Spring IDE
1) Lastes version of [Maven](https://maven.apache.org/)
1) Latest version of [Git client](https://git-scm.com/)
1) Latest version of [Concourse's fly command-line tool](https://github.com/concourse/fly)

# Contract Testing with Spring Cloud Contract

Your company may have many existing services that provide business functionality to customers, internal users and/or partners.
In our example, this __Person__ service provides people's valuable information to both new and legacy systems via __HTTP__ and __asynchronous messaging__

![The System](TheSystem.png)

## The Challenge: Service evolution
In order for you to keep up with market conditions, new regulations and the competition, you need to make schema changes and/or functionality changes to said services.
The question is: __How do you do that without impacting your existing consumers?__

## The Solution: Consumer-driven contracts
__Consumer-driven contracts__ allow you to test integration points between services providers and its consumers without setting up the whole runtime environment. Based on a common API contract, you can run isolated tests between the consumer and a mock provider; and, between a mock consumer and the real provider.

## The Tool: Spring Cloud Contract
With Spring Cloud Contract, you can successfully implement Consumer-driven Contracts for both JVM-based apps and non-JVM apps. Let's use two (2) Spring boot apps to understand how we can leverage Spring Cloud Contract.

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
