# InciDashboard_i2a

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a2c41f52eec04a038438c098967eaaae)](https://www.codacy.com/app/juanaza/InciDashboard_i2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciDashboard_i2a&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_i2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_i2a)
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_i2a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_i2a)

## Module information
The incidence dashboard will be used by the incident management staff, and can visualize and manage the incidents that appear in the system.

## Running the dashboard
In order to run the module, you need to follow these steps:

### Run Kafka
First of all, it is necessary to download Kafka from its [official webpage](https://kafka.apache.org/downloads).

Then, as the Kafka Quickstart guide explains, unzip the file you just downloaded and in a command line access to its root folder.

`> tar -xzf kafka_2.11-1.0.1.tgz`

`> cd kafka_2.11-1.1.0`

Once you are here, you need to start the server, included in Kafka.

#### Run Zookeeper

Execute the following command if you are using Windows:

`> bin/windows/zookeeper-server-start.bat config/zookeeper.properties`

If you are using any other operative system, execute this command as follows:

`> bin/zookeeper-server-start.sh config/zookeeper.properties`


#### Start Kafka
Once you have started the server, open another command line window and execute kafka as follows (in Windows):

`> bin/windows/kafka-server-start.bat config/server.properties`

In another operative system execute this command:

`> bin/kafka-server-start.sh config/server.properties`

### Run the application with Maven
Finally, to start the application, open a command line window, move to the application's directory and execute this command:

`> mvn spring-boot:run`

## Team Members
* Jesús Atorrasagasti García [@jesusatgar](https://github.com/jesusatgar)
* Juan Aza Gutiérrez [@juanaza](https://github.com/juanaza)
* Lorena Castillero Corriols [@lorenacasti](https://github.com/lorenacasti)

## Contributors
* Javier Díez García [@javicodema](https://github.com/javicodema)
