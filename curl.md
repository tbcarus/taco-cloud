curl http://localhost:8080/api/tacos?recent

curl http://localhost:8080/api/tacos/100004

curl -X DELETE localhost:8080/api/ingredients/GRBF --user user:pass

curl localhost:8080/api/ingredients

curl -X POST localhost:8080/api/ingredients -H"Content-type: application/json" –d"{\"id\":\"FISH\",\"name\":\"Stinky Fish\", \"type\":\"PROTEIN\"}"

curl -X DELETE localhost:8080/api/ingredients/FISH

curl -X POST localhost:8080/api/orders -H"Content-type: application/json" –d"{\"deliveryName\":\"FN\",\"deliveryStreet\":\"Lenina\", \"deliveryCity\":\"Moscow\", \"deliveryState\":\"MO\",\"deliveryZip\":\"123455\", \"ccNumber\":\"4738929451991773\",\"ccExpiration\":\"02/25\", \"ccCVV\":\"325\"}"