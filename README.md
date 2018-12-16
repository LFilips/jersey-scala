
# JettyTest

Simple application with scala and embedded jetty server that can be run just with a jar command. Every dependency is in the pom for a reason.

## RUN

The maven shade plugin is used to create a fat jar. Just create the jar with mvn clean package and then run it with
`java -jar {appName}`

## DEV

A jetty plugin is configured to run the application for dev, but is not recommend to use this in production.
