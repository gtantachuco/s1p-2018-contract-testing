#!/bin/bash

set -e -u -x

cd source-code/person-service
../mvnw clean install

cd ../myaccount-client
../mvnw clean install

