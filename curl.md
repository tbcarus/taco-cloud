curl http://localhost:8080/api/tacos?recent

curl http://localhost:8080/api/tacos/100004

curl -X DELETE localhost:8080/api/ingredients/GRBF --user user:pass

curl localhost:8080/api/ingredients

curl -X POST localhost:8080/api/ingredients -H"Content-type: application/json" –d"{\"id\":\"FISH\",\"name\":\"Stinky Fish\", \"type\":\"PROTEIN\"}"

curl -X DELETE localhost:8080/api/ingredients/FISH