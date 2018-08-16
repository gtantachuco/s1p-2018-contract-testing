# Contract Testing with Spring Cloud Contract

## The System
Your company/organization has many existing services that provide business functionality to customers, internal users and/or partners.
E.g: This Person service provides people information to both new and legacy systems.

![The System](TheSystem.png)

## The Challenge: Service evolution
In order for you to keep up with market conditions, new regulations and the competition, you need to make schema changes and/or functionality changes to said services.
The question is: __How do you do that without impacting your existing consumers?__

## Possible Solutions
Service providers usually adopt a cautious approach to changing any element of the contract they offer their consumers. Possible solutions may include:
1) Tolerant reader
1) Service versioning
1) __Consumer-driven contracts__. This is the focus of this demo.

## Consumer-driven contracts
__Consumer-driven contracts__ is a solution pattern that: 1) allows you to import consumer expectations as part of the service provider's test suite; and, 2) enables shorter feedback loops. 

__Who can use consumer-drive contracts?__ This pattern is applicable in the context of either a single enterprise or a closed community of well-know services where providers have some influence over how consumers establish contracts with them.

Together with unit and integration tests, contract tests should have their spot in the testing pyramid.
![Test Pyramid](testing_pyramid.png)

## Implementation: Spring Cloud Contract
### Pre-requisites

## Getting started
Run Person Service
Run Client app

## Scenario 1: Happy path

## Scenario 2: Change REST endpoint of the Person service's _Find By ID_ method

## Scenario 3: Change name of Person's _last name_ field

## Scenario 4: CI/CD with Concourse

## Scenario 5: Developing with Atomist

# Resources
REST and Async messaging example: <Marcin github repo: https://github.com/marcingrzejszczak/sc-contract-car-rental>
