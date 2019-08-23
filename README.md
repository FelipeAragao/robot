# robot

Running Project
-----
```
mvn clean install -DskipTests=false && mvn spring-boot:run
```

Endpoint
-----
```
curl -X POST \
  http://localhost:8080/rest/mars/MML \
  -H 'Postman-Token: 8665aaa4-c504-4c9a-ae4c-fb920dcd613d' \
  -H 'cache-control: no-cache'

```
