# Kafka Order Demo

A beginner-friendly Spring Boot project using Apache Kafka for event-driven order processing.

## Overview

This project demonstrates how to combine:

- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Apache Kafka
- PostgreSQL

The main goal is to show how a traditional CRUD-based application can evolve into an event-driven system.

When an order is created:

1. the API receives and validates the request
2. the order is saved to the database
3. an `order.created` event is published to Kafka
4. a consumer listens to the event and processes it asynchronously

## Why This Project?

If you already know Spring Boot, JPA, and basic CRUD, this is a great first Kafka project because it helps you understand:

- what a producer is
- what a consumer is
- how topics work
- how Kafka fits into real backend applications
- how asynchronous communication differs from direct service-to-service calls

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring for Apache Kafka
- Lombok
- PostgreSQL
- Docker Compose

## Architecture

```text
Client
  |
  v
POST /orders
  |
  v
Order Controller
  |
  v
Order Service
  | \
  |  \--> Save order with JPA
  |
  \-----> Publish event to Kafka
               |
               v
           Topic: orders
               |
               v
         Order Consumer
               |
               v
       Async event processing
```

## Project Flow

### Create Order

- the client sends a request to create an order
- the request is validated
- the application stores the order in the database
- the application publishes an `order.created` event
- the consumer receives the event and reacts to it

## Example Event

```json
{
  "eventType": "order.created",
  "orderId": 1,
  "customerName": "Daniel",
  "productName": "Mechanical Keyboard",
  "totalAmount": 399.90,
  "status": "CREATED",
  "createdAt": "2026-04-24T20:00:00Z"
}
```

## Suggested Features

- Create orders via REST API
- Persist data with JPA
- Publish order events to Kafka
- Consume events with `@KafkaListener`
- Add notification and inventory consumers later

## Learning Goals

By building this project, you will practice:

- REST API design
- request validation
- database persistence
- event publishing
- asynchronous processing
- basic event-driven architecture

## Possible Next Steps

- add `order.paid` and `order.cancelled`
- create a notification consumer
- create an inventory consumer
- add audit logging
- separate producer and consumer into different services
- study retry, dead-letter topics, and idempotency

## Summary

This project is a simple but practical introduction to Kafka for backend developers who already know Spring Boot and relational persistence.

It keeps the domain easy to understand while introducing one of the most important ideas in modern distributed systems: publishing events so that other parts of the system can react independently.

