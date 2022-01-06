# .NET Core test assignment
​
Create a .NET Core REST service
Service should accepts POST requests with JSON payload and return a string.
​
For example, given the request 
```
{  
    "operator":"plus",  
    "left": 5,  
    "right": 7  
}  
```
the response should be `"5+7=12"`.  
​
* Operator can be "plus", "minus", "multiply", "divide".  
* Operands are integers.
* Write unit tests (e.g. with xUnit).
* (Challenging) Use [DynamicProxy](http://www.castleproject.org/projects/dynamicproxy/ "DynamicProxy") or any better technology to transform calls to the service cachable - when service is called with the same input parameters, instead of computing the result again, it should return result from cache.
 * Make sure you handle edge cases properly and document your solution carefully.
