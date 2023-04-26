# Integration with External Public API

For a customer, take all the transactions in a given week and round them up to the nearest
pound. For example with spending of £4.35, £5.20 and £0.87, the round-up would be £1.58.
This amount should then be transferred into a savings goal, helping the customer save for
future adventures.

The task is to create a round-up feature for Starling customers using Starling Bank Public API which is available to all customers and partners.
It a Springboot REST API application written in Java. There are two APIs, one to fetch accounts ("/accounts") and other to calculate and save amount into a savings goal ("/round-up").
This application internally calls 3 APIs from Starling Bank Public API, Accounts API to fetch accounts for a customer, Transaction Feeds to fetch transaction feeds in a given period and Savings Goal API
to save a given amount towards a savings goal.



## Table of Contents

- [Design](#design)
- [Technologies](#technologies)
- [Tools](#tools)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Updates](#updates)
- [Contact](#contact)

## Design
I created a ```Springboot 3``` app which requires ```Java 17```+ compatibility. My app has three layers - Controller, Services and Client(Starling API). I have used ```Spring RestTemplate``` extensively to query Starling API. For Error Handling, adding headers in request, logging request and responses, I have used ```Spring Interceptors```. These interceptors are configured within RestTemplate. The app interacts with Starling API to fetch accounts and transactions. I used Java ```Stream API``` to calculate the rounded up value. The app calls the Savings Goal API to transfer the rounded up value to a saving goal. 
I have created test cases using ```JUnit 5```,``` MockMvc``` and ```Mockito```. 

## Technologies
1. Java 17
2. Springboot 3.0.5
3. Gradle
4. JUnit 5
5. MockMvc
6. Mockito

## Tools
1. IntelliJ IDEA
2. Postman Rest Client
3. Git

## Installation

This app uses Gradle as build tool. First build the project using ```./gradlew build``` and run the app from ```SbTechChallengeApplication.class```. This will start the
server at ```localhost:8080```. Now the app is ready to be tested in Postman.


## Usage

I have tested this app in Postman and provided examples in ```Starling Bank API.postman_collection.json```. Refer to the folder ```Technical_Challenge``` for app specific
APIs. The other APIs belong to Starling Bank Public API. The app needs Authorization token to be set in ```application.properties``` to access the Starling Bank Public API.

## Features

Following API calls are available which internally trigger the Starling Bank REST Resource: 
1. GET Request: ```localhost:8080/accounts```
   This method calls the Starling Bank Accounts API to return the accounts held by the caller.
   Response: 
   
   ```
   {
    "accounts": [
        {
            "accountUid": "9a38389c-17b8-4b46-89cd-2b88b10345c1",
            "accountType": "PRIMARY",
            "defaultCategory": "4f91690b-8a34-4730-851f-4834b4d986b3",
            "currency": "GBP",
            "createdAt": "2023-03-28T20:31:30.010Z",
            "name": "Personal"
        }
      ]
    }
    ```

2. POST Request: ```localhost:8080/roundUp```
   In this method I have used accountUid from accounts API and savingGoalUid from Saving Goal API by creating a saving goal. It also needs duration in the request body to fetch weekly transactions.
   This method calls accounts API, finds transaction feeds and calculates the rounded up value. Then it calls the Saving Goal API to save the rounded up amount into a saving goal.

   POST Request Body:
   
   ```
   {
    "accountUid": "9a38389c-17b8-4b46-89cd-2b88b10345c1",
    "savingGoalUid": "707613d3-96d5-49b8-9286-2af9782bfad6",
    "minTransactionTimestamp": "2023-03-28T20:31:30.010Z",
    "maxTransactionTimestamp": "2023-03-29T20:31:30.010Z"
    }
    ```
   
   Response:
   
    ```
    {
    "transferUid": "c9b418b5-d188-4469-a23e-0961e9f4760d",
    "success": true,
    "errors": null
    }
    ```

## Updates
Currently, I am working on adding the following: 
1. Add more failure test scenarios
2. Spring Security
3. Configure Spring-Retry to tackle transient errors
4. Add Swagger UI Documentation
5. Add lombok library


## Contact
Please reach out to me for any query regarding this repo: 

Saloni Dilip Thakare

salonidthakare@gmail.com

[LinkedIn](https://www.linkedin.com/in/saloni-dilip-thakare-762034105/)

