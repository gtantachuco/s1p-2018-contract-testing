#!/bin/bash

set -e -u -x

cd source-code/person-service
../mvnw clean install

cp target/*.jar ../../build-output/
