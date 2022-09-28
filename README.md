# Java API with AWS Lambda + DynamoDB

---

## An API able to perform crud:
- Using AWS Lamdda
- In a AWS DynamoDB

<br>

#### Libaries/dependencies/plugins used on IntelliJ:

> Also possible to verify the **pom.xml** file if you prefer


- **aws-lambda-java-core**
This library gives us two interfaces for handler method: RequestHandler and RequestStreamHandler

- **aws-java-sdk-dynamodb**
This SDK library has the client classes that are used for communicating with AWS DynamoDB

- **json-simple**
This library allow us to create and work with JSON

- **gson**
With this, it is possible to create string from a java object and java object from json string

- **mavem-compiler-plugin**
This plugin is used to compile the source code of a mavem project to an executable program

- **mavem-shade-plugin**
Provides capability to package the artifact in an uber-jar

- **gson**
With this, it is possible to create string from a java object and java object from json string
 <br>

### On AWS account, it was created:
- IAM Role
- DynamoDB
- Lambda function
- All in the same region, of course

<br>

**IAM Role**

- Created a role: *api-java-lambda-role*
   - *FullyDynamoDB access* and *BasicLambdaExecution*
   - Allowed Lambda to read and write to DynamoDB and create logs

<br>

**DynamoDB**

Added dummy data for test:
```json
{
 "id": 1,
 "name": "test product",
 "price": 9.99
}
```

<br>

**Lambda function**

- Added *api-java-lambda-role* to Lambda
- Uploaded file *jar* generated on IntelliJ
- Renamed the handler to: *click.henriquegibi.aws.crud.lambda.api.ProductLambdaHandler::handleRequest*
- Teste feito com o seguinte *PathParameters*:
```json
{
  "pathParameters": {
      "id":"1"
  }
}
```