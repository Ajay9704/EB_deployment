package eb.deployment.controllers

import grails.rest.*

class ApiController {
    static responseFormats = ['json']

    def index() {
        render(contentType: "application/json") {
            message = "Welcome to Grails 7 on AWS ElasticBeanstalk!"
            version = "0.1"
            endpoints = [
                "/health": "Health check endpoint",
                "/api": "This API endpoint",
                "/api/hello": "Hello world example"
            ]
        }
    }

    def hello() {
        render(contentType: "application/json") {
            message = "Hello, World! Your Grails 7 app is running on ElasticBeanstalk."
            timestamp = new Date().toString()
        }
    }
}
