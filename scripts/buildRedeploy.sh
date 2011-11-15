#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy jsfdemo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/jsfdemo.war
