# AWS ElasticBeanstalk Deployment Guide

This guide documents the step-by-step process of deploying the Grails 7 application to AWS ElasticBeanstalk.

## Prerequisites

- AWS Account with appropriate permissions
- AWS CLI installed and configured
- Java 17 or higher
- Grails 7.0.9 (via SDKMAN)

## Step 1: Build the Application

Create the production WAR file:

```bash
cd EB_deployment
./gradlew clean war
```

The WAR file will be generated at: `build/libs/eb-deployment-0.1.war`

## Step 2: Install ElasticBeanstalk CLI (Optional)

If using the EB CLI:
```bash
pip install awsebcli
```

## Step 3: Initialize ElasticBeanstalk Application

Option A: Using ElasticBeanstalk CLI
```bash
eb init -p java -r us-east-1 eb-deployment
```

Option B: Using AWS Console
1. Go to AWS ElasticBeanstalk console
2. Click "Create Application"
3. Name: `eb-deployment`
4. Platform: "Java"
5. Create application

## Step 4: Create Environment

Option A: Using EB CLI
```bash
eb create production-env
```

Option B: Using AWS Console
1. Click "Create environment"
2. Select "Web server environment"
3. Environment name: `eb-deployment-prod`
4. Platform: Java 17 (Corretto)
5. Upload the WAR file: `build/libs/eb-deployment-0.1.war`
6. Create environment

## Step 5: Configure Environment Variables

Configure application settings:

```bash
eb setenv SERVER_URL=http://your-env-url.elasticbeanstalk.com
```

Or in AWS Console (Configuration > Software):
- Add Environment Variable: `SERVER_URL` = `http://your-env-url.elasticbeanstalk.com`

## Step 6: Configure Health Check

ElasticBeanstalk needs to know how to check if the app is healthy.

1. Go to Configuration > Health
2. Set "Health Check Path" to: `/health`
3. The application returns `{"status":"UP"}` for health checks

## Step 7: Deploy the Application

If using Git:
```bash
eb deploy
```

Or manually upload WAR file in the AWS Console.

## Step 8: Verify Deployment

```bash
eb open
```

Or open the URL in browser and test endpoints:

- Health Check: `http://your-env-url.elasticbeanstalk.com/health`
- API Info: `http://your-env-url.elasticbeanstalk.com/api`
- Hello World: `http://your-env-url.elasticbeanstalk.com/api/hello`

## Common Issues Encountered

### Issue 1: Health Check Failed
**Cause:** Default health check path `/` might not respond correctly.
**Solution:** Configure health check path to `/health` in environment settings.

### Issue 2: 502 Bad Gateway
**Cause:** Application takes too long to start or crashes.
**Solution:** Check CloudWatch logs (`eb logs`). Ensure Java version matches (Java 17).

### Issue 3: Out of Memory
**Cause:** Default JVM heap size too small.
**Solution:** Set environment variable:
`JAVA_OPTS=-Xms512m -Xmx1024m`

## Cleanup

To avoid AWS costs, terminate the environment when done:

```bash
eb terminate --all
```

## Next Steps

- Add RDS PostgreSQL database integration
- Enable SSL/TLS with AWS Certificate Manager
- Configure auto-scaling groups
- Set up CloudWatch alarms for monitoring
