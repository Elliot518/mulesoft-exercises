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

### 3. Flow level error handling scenarios

- No error handler, taken over by Mule default error hanlder

![Mule default error hanlder](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/1_NoHandlerByDefault.png)

<hr>

- On Error Propagate in single flow

![On Error Propagate in single flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/2_ErrorPropagateSingleFlow.png)

<hr>


- On Error Continue in single flow

![On Error Continue in single flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/3_ErrorContinueSingleFlow.png)


<hr>

- On Error Propagate in both main flow and child flow
> Main flow reference child flow, child flow is On Error Propagate

![On Error Propagate in both flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/4_ErrorPropagateChildFlow.png)

<hr>

- On Error Continue in main flow, On Error Propagate in child flow

![Main Continue Child Propagate](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/5_MainContinueChildPropagate.png)

<hr>

- Whatever in main flow, On Error Continue in child flow

![On Error Continue in child flow](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/6_ContinueInChild.png)

&nbsp;

### 4. Handle errors at the application level

4-1) Drag "Error Handler" component and drop it in the canvas of global.xml

4-2) Drag "On Error Continue" component and drop it in globalError_Handler you just dragged on the canvas

4-3) In the On Error Continue properties view, click search button for type and select ANY
![Global Error Handler](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/GlobalErrorHandler.png)

4-4) Set the payload in the error handler to a JSON message
- Add a Transform Message component to the On Error Continue
- Set the Transform Message display name to error.description
- Inthe TransformMessage properties view, change the output type to application/json and give it a value of the error.description
![Error Handling Message](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/ErrorHandlingMessage.png)

4-5) Set a default error handler for the application
- In the Global Elements viewof global.xml, click Create
- Select Global Configurations > Configuration and click OK
![Select Global Configuration](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/SelectGlobalConfiguration.png)
- In the Global Element Properties dialog box, set the default error handler to globalError_Handler
![Set Global Error Handler](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/SetGlobalErrorHandler.png)

&nbsp;

### 5. Handle specific types of errors

5-1) Review the possible types of errors thrown by a HTTP Request

![Error Mapping](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/ErrorMapping.png)


5-2) Specifying scope execution for specific error types

- Add a second error handler scope to catch http request errors

![Error Types](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/ErrorHandlingWithTypes.png)

5-3) Specifying scope execution upon a specific condition

- Set the when condition to a Boolean DataWeave expression

eg: Scenario - HTTP:UNAUTHORIZED
```
1. error.errorType.namespace == 'HTTP'
2. error.errorType.identifier == 'UNAUTHORIZED'
3. error.cause.message contains 'request unauthorized'
4. error.cause.classcontains 'http'
```

![Error Condition](https://raw.githubusercontent.com/Elliot518/mcp-oss-repo/main/mulesoft/training/ErrorCondition.png)
