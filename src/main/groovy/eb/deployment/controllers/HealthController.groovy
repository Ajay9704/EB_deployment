package eb.deployment.controllers

import grails.rest.*

class HealthController {
    static responseFormats = ['json']

    def index() {
        render(contentType: "application/json") {
            status = "UP"
            application = "Grails 7 ElasticBeanstalk Demo"
            timestamp = new Date().toString()
            environment = grails.util.Environment.current.name
        }
    }
}
