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

&nbsp;


### 2. Error handling scopes

#### On Error Propagate

- All processors in the error handling scope are executed
- At the end of the scope 
    - The rest of the flow that threw the error is not executed
    - The error is rethrownup to the next level and handled there
- An HTTP Listener returns an **error** response

<hr>

#### On Error Continue

- All processors in the error handling scope are executed
- At the end of the scope 
    - The rest of the flow that threw the error is not executed
    - The event is passed up to the next level as if the flow execution had completed successfully 
- An HTTP Listener returns a **successful** response

&nbsp;

### 3. Main error handling scenarios

- No error handler, taken over by Mule default error hanlder

![Mule default error hanlder](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/1_NoHandlerByDefault.png)

<hr>

- On Error Propagate in single flow

![On Error Propagate in single flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/2_ErrorPropagateSingleFlow.png)

<hr>


- On Error Continue in single flow

![On Error Continue in single flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/3_ErrorContinueSingleFlow.png)


<hr>

- On Error Propagate in child flow
> Main flow reference child flow, child flow is On Error Propagate

![On Error Propagate in child flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/4_ErrorPropagateChildFlow.png)

