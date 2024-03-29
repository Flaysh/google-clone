
# Google Clone Project

Google Clone Application - Built with Java & Spring Boot

This is a Rest API that gets data from RapidAPI Google Search and present it to the UI.

Built with Spring Boot Library, a REST API Provider for JAVA, also using Jackson Library

to make the JSON response into A Plain Old Java Object.


## Deployment

To deploy this project run
```bash
  mvn install 
```
and then
```bash
  java -jar target/app-0.0.1-SNAPSHOT.jar
```
or
```bash
  mvn spring-boot:run
```




## API Reference

#### Get results

```http
  GET /search?query=
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `query` | `string` | **Required**. Search query |

#### Get Previous Results

```http
  GET /previous?query=
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `query`      | `string` | **Required**. Adds result and return the previous ones |



## Related Links
 - [Rapid API Google Search by apigeek](https://rapidapi.com/apigeek/api/google-search3)
 - [Spring Boot](https://spring.io/)
