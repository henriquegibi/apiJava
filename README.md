# Java API with AWS Lambda + DynamoDB

---

## An API able to perform crud:
- Using AWS Lamdda
- In a AWS DynamoDB

<br>

### On AWS account, it was created:
- IAM Role
- DynamoDB
- Lambda function
- All in the same region, of course

<br>

- **IAM Role**

Used a role with FullyDynamoDB access and BasicLambdaExecution
Allowed Lambda to read and write to DynamoDB and create logs

<br>

- **DynamoDB**

Added dummy data for test:
```json
{
 "id": 1,
 "name": "test product",
 "price": 9.99
}
```

<br>

- **Lambda function**



<br>

#### Libaries/dependencies/plugins used:

> Also possible to verify the **pom.xml** file if you prefer

<br>

- **aws-lambda-java-core**
This library gives us two interfaces for handler method: RequestHandler and RequestStreamHandler


<br>

- **aws-java-sdk-dynamodb**
This SDK library has the client classes that are used for communicating with AWS DynamoDB

<br>

- **json-simple**
This library allow us to create and work with JSON

<br>

- **gson**
With this, it is possible to create string from a java object and java object from json string

<br>

- **mavem-compiler-plugin**
This plugin is used to compile the source code of a mavem project to an executable program

<br>

- **mavem-shade-plugin**
Provides capability to package the artifact in an uber-jar

<br>

- **gson**
With this, it is possible to create string from a java object and java object from json string
