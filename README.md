# Asset API
An API secured by JSON Web Tokens for asset management.

## Architecture
 - Controller layer - contains all API endpoints
 - Service layer - contains all business logic
 - Database Layer - provides access to the database

## Docker
This project contains a Dockerfile. Make sure to generate a target .jar first. You can build a docker image by running the following command:

### Building
```shell
$ docker build --tag assets_api . 
```

Use the following command to build a docker container with port 8080 in the container mapped to port 8080 on the host:

### Deploying
```shell
$ docker run -d -p 8080:8080 --name assets_api_instance assets_api
```

Note: you might need to run docker with sudo privileges