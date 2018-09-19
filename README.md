# Pre-requisites
In order to complete this lab, you will need to install the following software in your computer:
1) [Spring Tool Suite](https://spring.io/tools) or your preferred Java/Spring IDE
1) Lastes version of [Maven](https://maven.apache.org/)
1) Latest version of [Git client](https://git-scm.com/)
1) Latest version of [Concourse's fly command-line tool](https://github.com/concourse/fly)

# Contract Testing
Dev teams frequently need to make schema changes and/or functionality changes to existing services.
The main challenge is: __How do you do that without impacting your existing consumers?__ Pivotal's solution is to leverage Consumer-driven contracts. That way, based on a common API contract, you can run integration tests between the consumer and a mock provider; and, between a mock consumer and the real provider; alll of this without setting up the _whole runtime environment_. 

# Contract Testing with Spring Cloud Contract
With Spring Cloud Contract, you can successfully implement Consumer-driven Contracts for both JVM-based apps and non-JVM apps. To understand Spring Cloud Contract concepts, let's use it in the context of two (2) Spring Boots apps:

1) The `PersonService` app (a.k.a. the producer) provides an API to find a given person using his or her ID
1) The `MyAccount` app (a.k.a. the consumer) accesses that API to get said person's names, email and phone. 

![The System](TheSystem.png)

The `MyAccount` app creates a consumer-driven contract to make sure that the integration with the `PersonService` app is aligned with the specifications. If, in the future, the API of the `PersonService` app changes, then the tests of `MyAccount` app will identify the incompatibility and consequently fail.


## Getting started
1) Create a folder in the filesystem and `cd` to it
1) `git clone https://github.com/gtantachuco-pivotal/s1p-2018-contract-testing.git`
1) Import it as an _Existing Maven project_ into your IDE. Choose the `s1p-2018-contract-testing` folder as the `Root Directory`

## Run the `PersonService` app
Let's build and run the app
```
cd <YOUR_FOLDER>/s1p-2018-contract-testing/person-service
mvn clean package
mvn spring-boot:run
```
Visit the `PersonService` app in the browser: [http://localhost:8000/person/1](http://localhost:8000/person/1) and [http://localhost:8000/person/2](http://localhost:8000/person/2)

Optionally, if you would like to know more about the `PersonService` app, please look at these files in your IDE:
1) `PersonService` API: `person-service/src/main/java/hello/PersonRestController.java`
1) Consumer-driven contract: `person-service/src/test/resources/contracts/hello/find_person_by_id.groovy`
1) Contract test's parent class: `person-service/src/test/java/hello/BaseClass.java`
1) Maven configuration file, which includes Spring Cloud Contract configuration: `person-service/pom.xml`

## Run the `MyAccount` app
Let's build and run the app
```
cd <YOUR_FOLDER>/s1p-2018-contract-testing/myaccount-client
mvn clean package
mvn spring-boot:run
```
Visit the `MyAccount` app in the browser: [http://localhost:9000/message/1](http://localhost:9000/message/1) and [http://localhost:9000/message/2](http://localhost:9000/message/2)

Optionally, if you would like to know more about the `MyAccount` app, please look at these files in your IDE:
1) MessageRestController's `getMessage` method: `/myaccount-client/src/main/java/hello/MyAccountApplication.java`
1) MyApp's contract test: `/myaccount-client/src/test/java/hello/MyAccountApplicationTest.java`. Look at the methods in the `StubRunnerRule` JUnit rule

## Service evolution - scenario 1: Change REST endpoint of the Person service's _Find By ID_ method

## Service evolution - scenario 1: Change name of Person's _last name_ field

## Scenario 4: CI/CD with Concourse
Our goal is to fail the build of the application when there is faulty integration, so together with unit and integration tests, contract tests should have a place in the testing pyramid.
![Test Pyramid](testing_pyramid.png)

## Scenario 5: Developing with Atomist

## Who should use consumer-drive contracts?
This pattern is applicable in the context of either a single enterprise or a closed community of well-know services where providers have some influence over how consumers establish contracts with them.


# Resources
REST and Async messaging example: <Marcin github repo: https://github.com/marcingrzejszczak/sc-contract-car-rental>
