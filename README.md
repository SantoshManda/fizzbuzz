# fizzbuzz 

#### Background: FizzBuzz
#### Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”.

#### FizzBuzz as a service

#### fizzbuzz is a web application that can do fizzbuzz as a web service. This server will support one GET endpoint:

Sample endpoint

http://localhost:8080/fizzbuzz/{upper bound as an integer}  

- HTTP GET http://localhost:8080/fizzbuzz/100



This service consumes an upper boundry as a path parameter, and determine which numbers would print "Fizz", "Buzz", and "FizzBuzz".

It will then respond to the caller with these numbers, grouped by Fizz, Buzz, and FizzBuzz. For example:

- HTTP GET - http://localhost:8080/fizzbuzz/15

Sample response

```json
{
  Fizz: [3,6,9,12],
  Buzz:[5,10],
  FizzBuzz:[15]
}
```


### Non integer path parameters will result in an error.

- HTTP GET - http://localhost:8080/fizzbuzz/dadsd 

Sample response

```json
{
"status":"BAD_REQUEST",
"localizedMessage":"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; 
nested exception is java.lang.NumberFormatException: For input string: \"dsadsa\"",
"error":"UpperBound should be of type java.lang.Integer"
}
```

### Special Charecters as path parameters will result in an error.

- HTTP GET - http://localhost:8080/fizzbuzz/*&%*

Sample response

```json
{
"status":"BAD_REQUEST",
"localizedMessage":"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; 
nested exception is java.lang.NumberFormatException: For input string: \"dsadsa\"",
"error":"UpperBound should be of type java.lang.Integer"
}
```


### wrong url would result in 404 error

- HTTP GET - http://localhost:8080/fiz

Sample response

> Requested resource/service is not available



### Negative input (UpperBound) would lead to custom exception

- HTTP GET - http://localhost:8080/fizzbuzz/-4

Sample response

```json
{
"status":"BAD_REQUEST",
"localizedMessage":"Upper Bound should be greater than zero ",
"error":"Upper Bound should be greater than zero "
}
```


### FizzbuzzApplicationTests.java class contains JUNIT test cases for the application

* contextLoads()  
> to test that fizzbuzzservice and fizzbuzzdao beans are loaded 
* testInput15() 
> to test for UpperBound 15
* testInput100() 
> to test for UpperBound 100
* testInputNonNumeric() 
> to test for NonNumeric UpperBound
* testInputSpecialCharecters() 
> to test for SPecial Charecters in UpperBound
* testInput1() 
> to test for UpperBound 1
* testInputNegative()  
> to test for Negative UpperBound
* testInputTimeOut()  
> to test Timeout of a UNIT test when upper bound value is 1000000 with 5 sec time out window.
* testInvalidPath()  
> to test for Rest calls with invalid url (path).

