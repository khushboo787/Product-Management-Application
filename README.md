# Product-Management-Application

This Spring Boot application provides a RESTful API to fetch product details from a MySQL database. The API supports filtering and sorting based on various parameters.
<br>

### 👨🏻‍💻 Tech Stack & Languages Used
- Java
- Spring Boot
- Spring Data JPA
- Maven
- Hibernate
- MySQL

### Functionalities

#### Filtering:
- **Category:** Filter by product category.
- **Price:** Filter by price range (min and max).
- **InStock:** Filter by stock availability.

#### Sorting:
- **Fields:** Price, rating, createdAt.
- **Order:** Ascending or descending.

## Installation & Run

Follow these steps to run the application:

### 1. Clone the Repository

Clone the repository to your local machine using Git:
```
git clone https://github.com/khushboo787/Product-Management-Application.git
cd Product-Management-Application

```

* Before running the API server, you should update the database config inside the [application.properties](Product-Management-System\src\main\resources\application.properties) file.
* Update the port number, username and password as per your local database config.
  
  ```
    server.port=8888
    spring.datasource.url=jdbc:mysql://localhost:3306/cart;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

  ```

## API Root Endpoint
The API documentation and interactive testing can be accessed at:

`http://localhost:8080/swagger-ui/index.html#/`


### Sample API Response
To fetch product details with filtering and sorting, use the following GET request:

#### Request 
`GET: http://localhost:8080/products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc`


#### Response
A successful response will return a JSON array of products matching the specified criteria. Here is an example response:

```
[
  {
    "id": 1,
    "name": "Smartphone",
    "category": "electronics",
    "price": 299.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2023-01-15T12:00:00Z"
  },
  {
    "id": 2,
    "name": "Laptop",
    "category": "electronics",
    "price": 899.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2023-03-20T08:30:00Z"
  }
]

```

### Key Points:

- **Endpoint URL:** Make sure the URL used in the `Request` section matches your actual API endpoint.
- **Request Parameters:** The parameters `category`, `minPrice`, `maxPrice`, `inStock`, `sortField`, and `sortOrder` allow you to filter and sort the product list.
 
 
