[Back](README.md)

## Handling Errors

<hr>


### 1. Default error handling

When an event is being processed through a Mule flow that throws an error

- Normal flow execution stops 
- The event is passed to the first processor in an error handler 

