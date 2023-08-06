#!/bin/bash
mvn clean:clean generate-sources

echo "INIT COPY GENERATED SOURCES"

rm -rf src/generated/META-INF && cp -vnpr src/generated/* src/main/java && rm -rf src/generated/

echo "END COPY GENERATED SOURCES. BUILDING"

mvn clean:clean resources:resources compiler:compile


