[Back](README.md)

## Controlling event flow

<hr>

### 1. Routers

- Choice(条件分支)
> One route executed based on conditional logic

- First Successful
> Routes executed sequentially until one is successfully executed

- Round Robin
> One route executed, which one is selected by iterating through a list maintained across executions

- Scatter-Gather
> All routes executed concurrently

```
eg: Multicast an event
Scenario: 

A flow that calls each of the three airline services and combines the results:
1) Use a Scatter-Gather router to concurrently call all three flight services
2) Use DataWeave to flatten(扁平化) multiple collections into onecollection
```

Use theDataWeave flatten function to flatten the collection of objects into a single collection:
```
output application/java
---
flatten(payload..payload)
```


