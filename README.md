# Spring Rest - A RESTful API written in Spring Boot

This is a simple app using Spring Boot as part of [Red Hat OpenShift Application Runtimes](https://middlewareblog.redhat.com/2017/05/05/red-hat-openshift-application-runtimes-and-spring-boot-details-you-want-to-know/).

## Usage

1. `git clone`
2. `mvn spring-boot:run`

## OpenAPI (formerly known as Swagger) Support

The app uses [Spring Fox](http://springfox.github.io/springfox/) to generate an [OpenAPI spec](https://www.openapis.org/). You can view the spec at /swagger.json or [Swagger UI](https://swagger.io/swagger-ui/) at /swagger-ui.html.

## Deploy on OpenShift

First Create a project
```
oc new-project sunset --display-name "Sunset Blvd"

```

Deploy the App using s2i strategy
```
oc new-app appuio/s2i-maven-java~https://github.com/ajarv/spring-rest.git --name green-rest-app
``` 

Success if your console indicates
```
--
--
--> Success
    Build scheduled, use 'oc logs -f bc/green-rest-app' to track its progress.
    Application is not exposed. You can expose services to the outside world by executing one or more of the commands below:
     'oc expose svc/green-rest-app'
    Run 'oc status' to view your app.
```

Create route

```
app_host_name=green-rest-app.dev.${INFRA_NODE_LB_IP}.nip.io
oc expose svc/green-rest-app --hostname=${app_host_name}

```


## Cleanup 
```
oc delete project sunset

```
