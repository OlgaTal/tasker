package com.chyld.controllers;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/clean-database.sql"})
public class TasksControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // GET /api/tasks
    public void shouldGetAllTheTasks() throws Exception {
        get("/api/tasks")
                .then()
                .statusCode(200)
                .body("numberOfElements", is(3));
    }

    @Test
    // GET /api/tasks/:id
    public void shouldGetASingleTask() throws Exception {
        get("/api/tasks/1")
                .then()
                .statusCode(200)
                .body("name", is("Get Milk"));
    }
}




// "totalPages": 2,
//         "last": false,
//         "totalElements": 5,
//         "size": 3,
//         "number": 0,
//         "first": true,
//         "sort": null,
//         "numberOfElements": 3
