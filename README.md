# microservice
1. Configserver: This microservice provides as centralized coniguration location
2. ordermicroservice: This is demo microservice which is responsible to take order details from the user further it calls the paymentmicroservice to process the payment
3. paymentmicroservice: This microservice process the payment and retunrs the result back to the orderservice
4. servicereg: This microservice is the service registry in this example I have taken Eureka as a service registry. it is nothing but the EurekaServer where all the microservice list themselves with this service registry
5. springapigateway: This microservice acts as a single point of contact for rest of the world, it also takes care of the fault talaurance/circuit breaker using hystrix 

To run this entire ecosystem of microservices, just run each individual microservice as a java application.

Eureka server url : http://localhost:8761/

To execute microservice flow-> 

 a. post url: http://localhost:8989/order/bookorder
 
 b. url body
    
    {
    "order": {
        "id": 1010,
	  "name":"abd",
	  "qty": 10,
	  "price": 1010
    },
    "payment":{}   
    }
    
Configure the above request as a raw json in postman
