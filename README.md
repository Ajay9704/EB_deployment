# Grails 7 ElasticBeanstalk Deployment - Learning Project

A simple Grails 7 application I'm building to understand AWS ElasticBeanstalk deployment. This is part of my learning journey as I prepare for GSoC 2026 with Apache Grails.

## Current Status

**In Development** - I'm currently learning Grails 7 and exploring AWS deployment options. This application represents my progress in understanding:
- Grails 7 framework fundamentals
- REST API development conventions
- AWS ElasticBeanstalk deployment workflow

## Application Details

- **Framework**: Grails 7.0.9
- **Profile**: REST API
- **Purpose**: Learning project to master Grails deployment to AWS
- **Status**: Local development complete, AWS deployment in progress

## What I've Learned So Far

### Completed
- Set up basic Grails 7 REST API application
- Implemented health check endpoint for load balancers
- Created simple API controllers following Grails conventions
- Configured production-ready application.yml settings
- Successfully run application locally with `./gradlew bootRun`

### Currently Learning
- AWS ElasticBeanstalk platform configuration
- Deployment workflow and environment setup
- Health check configuration and monitoring
- Production-ready deployment patterns

### Next Steps
- Deploy first version to AWS ElasticBeanstalk
- Add RDS PostgreSQL database integration
- Implement proper logging with CloudWatch
- Add SSL/TLS configuration
- Document the complete deployment process

## Features

- REST API endpoints
- Health check endpoint for ElasticBeanstalk (`/health`)
- Production-ready configuration structure
- H2 in-memory database (for local development)

## Endpoints

- `GET /health` - Health check endpoint (returns 200 OK)
- `GET /api` - API information
- `GET /api/hello` - Hello world example

## Running Locally

```bash
# Clone the repository
git clone https://github.com/Ajay9704/EB_deployment.git
cd EB_deployment

# Using SDKMAN (if you have it)
source ~/.sdkman/bin/sdkman-init.sh

# Run the application
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
./gradlew clean war
```

This creates a WAR file in `build/libs/` ready for deployment

## AWS Deployment

I'm documenting my deployment learning process in `DEPLOYMENT.md`. This guide represents my understanding and notes as I work through the ElasticBeanstalk deployment process.

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
├── build.gradle                   # Gradle build configuration
├── Procfile                       # ElasticBeanstalk process configuration
└── DEPLOYMENT.md                  # Deployment learning notes
```

## Learning Resources

This project is part of my preparation for:
- GSoC 2026 Apache Grails proposal
- Creating updated deployment guides for Grails 7/8
- Understanding modern cloud deployment patterns

## Contributing

This is primarily a learning project, but feedback and suggestions are welcome! Feel free to open an issue or pull request.

## License

Apache License 2.0

## Author

**Budida Ajay**
- GitHub: [@Ajay9704](https://github.com/Ajay9704)
- Learning Grails and cloud deployment patterns
- Preparing for GSoC 2026 with Apache Grails

---

**Note**: This represents my ongoing learning process. I'm documenting my progress and lessons learned as I work through deploying Grails applications to AWS. The deployment guide will be updated as I gain more hands-on experience with ElasticBeanstalk.
