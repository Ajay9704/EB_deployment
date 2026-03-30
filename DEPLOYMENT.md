# AWS ElasticBeanstalk Deployment Guide - Work in Progress

This guide documents my learning process and notes for deploying the Grails 7 application to AWS ElasticBeanstalk. I'm working through this deployment as part of my GSoC 2026 preparation with Apache Grails.

## Current Status

**Learning in Progress** - I'm currently studying the ElasticBeanstalk deployment workflow. This guide represents my research and understanding so far, but I haven't completed a full production deployment yet.

## What I'm Researching

### Understanding the Deployment Process
I'm currently learning about:
- AWS ElasticBeanstalk platform options for Java applications
- Required configurations for Grails applications
- Health check setup and monitoring
- Environment variable configuration
- Deployment strategies (rolling deployments, blue-green)

### Prerequisites I'm Setting Up

- AWS Account with appropriate permissions
- AWS CLI installation and configuration
- Java 17+ runtime environment
- Grails 7.0.9 (via SDKMAN)
- Understanding of WAR file deployment process

## Planned Deployment Steps

### Step 1: Build the Application

Create the production WAR file:

```bash
cd EB_deployment
./gradlew clean war
```

The WAR file will be generated at: `build/libs/eb-deployment-0.1.war`

### Step 2: Install ElasticBeanstalk CLI (Research Phase)

The EB CLI appears to be the recommended approach:

```bash
pip install awsebcli
```

### Step 3: Initialize ElasticBeanstalk Application (Planned)

I'm planning to use the ElasticBeanstalk CLI:

```bash
eb init -p java -r us-east-1 eb-deployment
```

Alternatively, the AWS Console approach:
1. Go to AWS ElasticBeanstalk console
2. Click "Create Application"
3. Name: `eb-deployment`
4. Platform: "Java"
5. Create application

### Step 4: Create Environment (To Be Done)

Planning to use:
```bash
eb create production-env
```

AWS Console approach:
1. Click "Create environment"
2. Select "Web server environment"
3. Environment name: `eb-deployment-prod`
4. Platform: Java 17 (Corretto)
5. Upload the WAR file: `build/libs/eb-deployment-0.1.war`
6. Create environment

### Step 5: Configure Environment Variables (Researching)

Need to configure:
```bash
eb setenv SERVER_URL=http://your-env-url.elasticbeanstalk.com
```

Or in AWS Console (Configuration > Software):
- Add Environment Variable: `SERVER_URL`

### Step 6: Configure Health Check (Learning)

ElasticBeanstalk needs to know how to check if the app is healthy.

1. Go to Configuration > Health
2. Set "Health Check Path" to: `/health`
3. The application returns `{"status":"UP"}` for health checks

### Step 7: Deploy the Application (Planning)

If using Git:
```bash
eb deploy
```

Or manually upload WAR file in the AWS Console.

### Step 8: Verify Deployment (To Be Done)

```bash
eb open
```

Or open the URL in browser and test endpoints:
- Health Check: `http://your-env-url.elasticbeanstalk.com/health`
- API Info: `http://your-env-url.elasticbeanstalk.com/api`
- Hello World: `http://your-env-url.elasticbeanstalk.com/api/hello`

## Potential Issues I'm Researching

### Issue 1: Health Check Configuration
**What I'm Learning:** Default health check path `/` might not respond correctly.
**Planned Solution:** Configure health check path to `/health` in environment settings.

### Issue 2: Startup Time
**What I'm Reading:** Applications might take time to start or could crash if misconfigured.
**Planned Approach:** Check CloudWatch logs (`eb logs`). Ensure Java version matches (Java 17).

### Issue 3: Memory Configuration
**What I'm Studying:** Default JVM heap size might be too small.
**Planned Solution:** Set environment variable: `JAVA_OPTS=-Xms512m -Xmx1024m`

## Next Steps for My Learning

1. **Complete First Deployment**: Successfully deploy this basic app to ElasticBeanstalk
2. **Add Database Integration**: Connect to RDS PostgreSQL
3. **Implement SSL/TLS**: Use AWS Certificate Manager
4. **Configure Auto-scaling**: Set up scaling groups based on load
5. **Set Up Monitoring**: Configure CloudWatch alarms and logging
6. **Document Complete Process**: Create comprehensive guide with real experience

## Resources I'm Using

- AWS ElasticBeanstalk Documentation
- Grails Deployment Guides
- Spring Boot on AWS documentation
- Community forums and Stack Overflow

## Cleanup (When Testing)

To avoid AWS costs during learning:

```bash
eb terminate --all
```

## My Goals

This deployment guide is part of my larger goal to:
1. Gain hands-on experience with AWS deployment
2. Understand production deployment patterns
3. Create comprehensive, updated guides for Grails 7/8
4. Contribute back to the Apache Grails community
5. Prepare for GSoC 2026 project work

---

**Note**: This is a living document that I'll update as I gain more hands-on experience with ElasticBeanstalk deployments. My goal is to turn these learning notes into a comprehensive, production-ready deployment guide for the Grails community.

**Last Updated**: March 2026 - Initial research and planning phase
