//build project
mvn clean install

//build docker app image
docker build -t spring-boot-app:1.0 .

//run docker app image
docker-compose up


//import billing.postman_collection.json to use API.