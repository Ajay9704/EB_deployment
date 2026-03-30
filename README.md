# Grails 7 ElasticBeanstalk Deployment Demo

A simple Grails 7 application demonstrating deployment to AWS ElasticBeanstalk.

## Application Details

- **Framework**: Grails 7.0.9
- **Profile**: REST API
- **Purpose**: Learning project for understanding AWS ElasticBeanstalk deployment

## Features

- REST API endpoints
- Health check endpoint for ElasticBeanstalk
- Production-ready configuration
- H2 in-memory database

## Endpoints

- `GET /health` - Health check endpoint (returns 200 OK)
- `GET /api` - API information
- `GET /api/hello` - Hello world example

## Running Locally

```bash
# Using SDKMAN
source ~/.sdkman/bin/sdkman-init.sh
./gradlew bootRun
```

The application will be available at `http://localhost:8080`

## Testing Endpoints

```bash
# Health check
curl http://localhost:8080/health

# API info
curl http://localhost:8080/api

# Hello world
curl http://localhost:8080/api/hello
```

## Building for Production

```bash
./gradlew clean assemble
```

This creates a WAR file in `build/libs/`

## Deployment to ElasticBeanstalk

See the detailed deployment guide in `DEPLOYMENT.md`

## Project Structure

```
├── src/main/groovy/eb/deployment/
│   ├── Application.groovy          # Main application class
│   ├── controllers/                # REST controllers
│   │   ├── HealthController.groovy
│   │   └── ApiController.groovy
│   └── UrlMappings.groovy         # URL routing configuration
├── src/main/resources/
│   └── application.yml           # Application configuration
└── build.gradle                   # Gradle build configuration
```

## License

Apache License 2.0

## Author

Budida Ajay 
