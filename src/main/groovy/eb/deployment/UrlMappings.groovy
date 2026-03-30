package eb.deployment

class UrlMappings {

    static mappings = {
        "/health"(controller: "health", action:"index")
        "/api"(controller: "api", action:"index")
        "/api/hello"(controller: "api", action:"hello")
        
        "/"(controller: "application", action:"index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
