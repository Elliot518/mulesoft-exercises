[Back](README.md)

## Handling Errors

<hr>


### 1. Default error handling

When an event is being processed through a Mule flow that throws an error

- Normal flow execution stops 
- The event is passed to the first processor in an error handler 

![Default error handling](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/DefaultErrorHandling.png)


If there is no error handler defined, a Mule default error handler is used
- Implicitly and globally handles all messaging errors thrown in Mule applications
- Stops execution of the flow and logs information about the error
- Cannot be configured
