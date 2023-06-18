curl http://localhost:8080/api/tacos?recent

curl http://localhost:8080/api/tacos/100004

curl -X DELETE localhost:8080/api/ingredients/GRBF --user user:pass

curl localhost:8080/api/ingredients

curl -X POST localhost:8080/api/ingredients -H"Content-type: application/json" –d"{\"id\":\"FISH\",\"name\":\"Stinky Fish\", \"type\":\"PROTEIN\"}"

curl -X DELETE localhost:8080/api/ingredients/FISH



curl localhost:8080/actuator/metrics/tacocloud
curl localhost:8080/actuator/metrics/tacocloud?tag=ingredient:FLTO

curl localhost:8080/actuator/notes -d"{\"text\":\"Bring home milk\"}" -H"Content-type: application/json"
curl localhost:8080/actuator/notes -d"{\"text\":\"Take dry cleaning\"}" -H"Content-type: application/json"
curl localhost:8080/actuator/notes
cur  -X DELETE localhost:8080/actuator/notes?index=1