## Description
PoC Training Springboot Mongodb Backend Topics Resources

## Start container services

We create a network with two services: mongodb and loopback backend service

**STEP01**: Create a network for container services

```sh
docker network create training
```

**STEP02**: Start mongo db without any account, expose default mongo port and connect to previous network

```sh
docker run --name trainingdb -d -p 27017:27017 --network training mongo
```

**STEP03**: Build springboot backend image

```sh
docker build -t poc-docker-springboot-backend .
```

**STEP04**: Start springboot backend container service

Start from host the dev profile (active profile)
```sh
./mvnw spring-boot:run
```

Start from host the docker profile

```sh
./mvnw spring-boot:run -Dspring-boot.run.profiles=docker
```

Start container in docker passing the environment variable called SPRING_PROFILES_ACTIVE to activate the correct spring profile
```sh
docker run --name poc-docker-springboot-backend -d -e "SPRING_PROFILES_ACTIVE=docker" -p 8080:8080 --network training poc-docker-springboot-backend
```