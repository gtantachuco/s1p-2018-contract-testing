# Contract Testing with Spring Cloud Contract

## The System
Your company/organization has many existing services that provide business functionality to customers, internal users and/or partners.
E.g: This Person service provides people information to both new and legacy systems.

![The System](TheSystem.png)

## The Challenge: Service evolution
In order for you to keep up with market conditions, new regulations and the competition, you need to make schema changes and/or functionality changes to said services.
The question is: __How do you do that without impacting your existing consumers?__

## Possible Solutions

## Enter Spring Cloud Contract

Together with unit and integration tests, contract tests should have their spot in the testing pyramid.
![Test Pyramid](testing_pyramid.png)

## Pre-requisites

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
