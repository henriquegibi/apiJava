package click.henriquegibi.aws.crud.lambda.api;

import click.henriquegibi.aws.crud.lambda.api.model.Product;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ProductLambdaHandler implements RequestStreamHandler {
    
    private String DYNAMO_TABLE = "Products";
    
    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException
    {
        OutputStreamWriter writer = new OutputStreamWriter(output);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        JSONParser parser = new JSONParser();
        JSONObject responseObject = new JSONObject();
        JSONObject responseBody = new JSONObject();
    
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDB dynamoDB = new DynamoDB(client);
        
        int id;
        Item resItem = null;

        try
        {
            JSONObject reqObject = (JSONObject) parser.parse(reader);
            if(reqObject.get("pathParameters")!= null)
            {
                JSONObject pps = (JSONObject) reqObject.get("pathParameters");
                if (pps.get("id")!=null)
                {
                    id = Integer.parseInt((String)pps.get("id"));
                    resItem = dynamoDB.getTable(DYNAMO_TABLE).getItem("id", id);
                }
            }
            else if (reqObject.get("querryStringParameters")!=null)
            {
                JSONObject qps = (JSONObject) reqObject.get("querryStringParameters");
                if (qps.get("id")!=null)
                {
                    id = Integer.parseInt((String) qps.get("id"));
                    resItem = dynamoDB.getTable(DYNAMO_TABLE).getItem("id",id);
                }
            }
            if (resItem!=null)
            {
                Product product = new Product(resItem.toJSON());
                responseBody.put("product", product);
                responseObject.put("statusCode", 200);
            }
            else
            {
                responseBody.put("message", "No Items Found");
                responseObject.put("statusCode", 404);
            }
            
            responseObject.put("body", responseBody.toString());
        }
        catch (Exception e)
        {
            context.getLogger().log("ERROR: " + e.getMessage());
        }
        writer.write(responseObject.toString());
        reader.close();
        writer.close();
    }
}