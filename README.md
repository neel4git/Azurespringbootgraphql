# Spring Boot with GraphQL Query Example

## Book Store
- `/api/product` is the REST resource which can fetch Books information
- DataFetchers are Interfaces for RuntimeWiring of GraphQL with JpaRepository

## Sample GraphQL Scalar Queries
- first run : mvn clean package azure-functions:run
- Accessible under `http://localhost:7071/api/product`
- Usage for `allBooks`
`{
   allBooks {
     isn
     title
     authors
     publisher
   }
 }`
- Usage for `book`
`{
   book(id: "123") {
     title
     authors
     publisher
   }`
- Combination of both `allBooks` and `book`
`{
   allBooks {
     title
     authors
   }
   book(id: "124") {
     title
     authors
     publisher
   }
 }`