## REST API using Java JAX-RS on Apache Tomcat

The Java API for RESTful Web Services provides portable APIs for developing, exposing
and accessing Web applications designed and implemented in compliance with principles
of REST architectural style.

`base_url` is `http://localhost/restapp/`

*Back End Database* is `MySQL` database;

### How To Setup

1. Import this (maven) repository into any Java EE IDE with Tomcat Installed.

2. Import `src/main/resources/friends.sql` in any `mysql` database;

3. Change `mysql` configuration in `src/main/resources/mysql.properties`.

3. Run `Maven Clean` through IDE or Command Line.

4. Run on Tomcat Server or `maven install` and copy `target/restapp.war` into `$TOMCAT/webapps/` directory.

### How To Test

Add chrome extension [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) which is a
REST Api Client to test this application.

| HTTP Method | Path | Action | Fields  |
| -------- | ------- | -----  | ------- |
| GET      | /users  | index  | 
| GET      | /users/{user_id} | index   | 
| POST     | /users  | Add    | *rollno* (int), *name*, *email*, *phone* and *company* with <br /> header `Content-Type: application/x-www-form-urlencoded`
| PUT      | /users/{user_id} | update  | *rollno* (int), *name*, *email*, *phone* and *company* with <br /> header `Content-Type: application/x-www-form-urlencoded`
| DELETE   | /users/{user_id} | destroy |

### Todo

1. Add OAuth 2.0 Support
