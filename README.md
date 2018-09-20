## Pre-requisites
In order to complete this lab, you will need to install the following software in your computer:
1) [Spring Tool Suite](https://spring.io/tools) or your preferred Java/Spring IDE
1) Lastes version of [Maven](https://maven.apache.org/)
1) Latest version of [Git client](https://git-scm.com/)
1) Latest version of [Docker](https://www.docker.com/) and [Docker Compose](https://docs.docker.com/compose/)
1) Latest version of [Concourse's fly command-line tool](https://github.com/concourse/fly)

## Contract Testing
Dev teams frequently need to make schema changes and/or functionality changes to existing services.
The main challenge is: __How do you do that without impacting your existing consumers?__ Pivotal's recommendation is to leverage Consumer-driven contracts. That way, based on a common API contract, you can run integration tests between the consumer and a mock provider; and, between a mock consumer and the real provider; alll of this without setting up the _whole runtime environment_. 
The goal is to fail the build of the application when there is faulty integration, so together with unit and integration tests, contract tests should have a place in the testing pyramid.
![Test Pyramid](testing_pyramid.png)

## Who should use consumer-drive contracts?
This pattern is applicable in the context of either a single enterprise or a closed community of well-know services where providers have some influence over how consumers establish contracts with them.

## Contract Testing with Spring Cloud Contract
With Spring Cloud Contract, you can successfully implement Consumer-driven Contracts for both JVM-based apps and non-JVM apps. To understand Spring Cloud Contract concepts, let's use it in the context of two (2) Spring Boots apps:

1) The `PersonService` app (a.k.a. the producer) provides an API to find a given person using his or her ID
1) The `MyAccount` app (a.k.a. the consumer) accesses that API to get said person's names, email and phone. 

![The System](TheSystem.png)

## Getting started
1) Create a folder in the filesystem and `cd` to it
1) `git clone https://github.com/gtantachuco-pivotal/s1p-2018-contract-testing.git`
1) Import it as an _Existing Maven project_ into your IDE. Choose the `s1p-2018-contract-testing` folder as the `Root Directory`

## Build the `PersonService` app
During the present Sprint, the `PersonService` team creates the contract test's parent class: [BaseClass](person-service/src/test/java/hello/BaseClass.java).

In addition, the `MyAccount` team created the consumer-driver contract [find_person_by_id.groovy](person-service/src/test/resources/contracts/hello/find_person_by_id.groovy); and provided it to the `PersonService` team, which included the contract definition in the `PersonService` codebase

We are ready to build the app via these commands:
```
cd <YOUR_FOLDER>/s1p-2018-contract-testing/person-service
mvn clean package
```
This picture depicts what happens when you build the app:
![build-person-service](build-person-service.png)

1) The [Maven build](person-service/pom.xml) and Spring Cloud Contract Verifier use the contract definition to _automatically generate_ full tests
1) You can use your IDE to view the source code of the generated test at: `/person-service/target/generated-test-sources/contracts/hello/HelloTest.java`
1) Once Spring Cloud Contract verifies that `PersonService` implementation is compliant with the contract, Maven generates and installs both Stubs (`person-service-0.0.1-SNAPSHOT-stubs.jar`) and the `PersonService` app (`person-service-0.0.1-SNAPSHOT.jar`) artifacts in the designated Maven repo

## Build the `MyAccount` app
During the same Sprint, the `MyAccount` app has also created a [consumer-driven contract test](/myaccount-client/src/test/java/hello/MyAccountApplicationTest.java) to ensure the integration with the `PersonService` app is aligned with the specifications.

Let's build the app:
```
cd <YOUR_FOLDER>/s1p-2018-contract-testing/myaccount-client
mvn clean package
```
This picture depicts what happens when you build the app:

![build-myaccount-client](build-myaccount-client.png)

1) When the [Maven build](/myaccount-client/pom.xml) is executed, the Spring Cloud Contract Stub Runner in your JUnit test will automatically download the required stubs from the designated Maven repo
1) The Spring Cloud Contract Stub Runner will also automatically start a WireMock server inside your test and feed it with the stubs it downloaded in the previous step
1) Once Spring Cloud Contract verifies that `MyAccount` implementation is compliant with the contract, Maven generates and installs `myaccount-client-0.0.1-SNAPSHOT.jar` in the designated Maven repo

## Service evolution: Change `PersonService` endpoint from `/person` to `/people`
1) Open your IDE
1) Find the `findPersonById` method in the [PersonRestController](/person-service/src/main/java/hello/PersonRestController.java) 
1) Change its annotation from `@GetMapping("/person/{id}")` to `@GetMapping("/people/{id}")`. Save your changes.
1) Build the `PersonService` app
1) Was the build successful or it failed? Why?
1) Change its annotation back to `@GetMapping("/person/{id}")`. Save your changes
1) Build the `PersonService` app

## Service evolution: Change `Person` schema attribute from `surname` to `lastname`
1) Open your IDE
1) Find the [Person class](/person-service/src/main/java/hello/Person.java) 
1) Use your IDE to replace the `surname` string with `lastname`. Save your changes
1) Build the `PersonService` app
1) Was the build successful or it failed? Why?
1) Use your IDE to replace the `lastname` string with `surname`. Save your changes
1) Build the `PersonService` app

## Use CI/CD pipeline with Concourse


# Resources
REST and Async messaging example: <Marcin github repo: https://github.com/marcingrzejszczak/sc-contract-car-rental>
