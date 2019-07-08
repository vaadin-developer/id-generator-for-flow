#!/bin/bash
function docker_tag_exists() {
    EXISTS=$(curl -s  https://hub.docker.com/v2/repositories/$1/tags/?page_size=10000 | jq -r "[.results | .[] | .name == \"$2\"] | any")
    test $EXISTS = true
}

if docker_tag_exists working/vaadin-id-generator-for-flow 20190628-001; then
    echo skip building, image already existing - working/vaadin-id-generator-for-flow 20190628-001
else
    echo start building the images
    docker build -t working/vaadin-id-generator-for-flow .
#    docker tag working/vaadin-id-generator-for-flow:latest working/vaadin-id-generator-for-flow:20190628-001
#    docker push working/vaadin-id-generator-for-flow:20190628-001
fi

#svenruppert/maven-3.6.1-openjdk:1.11.0-2