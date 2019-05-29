package com.graphql.azurefunctionsspringbootgrapqlexample;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;


public class ContentHandler extends AzureSpringBootRequestHandler<String, HttpResponseMessage> {

    @FunctionName("ContentHandler")
    public HttpResponseMessage run(@HttpTrigger(name = "req", methods = {HttpMethod.OPTIONS,
                    HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS, route = "product") HttpRequestMessage<Optional<String>> request,
                    ExecutionContext context) {
        context.getLogger().info("Recieved request to process product query");
        System.out.println("received the request");
        if (request.getHttpMethod().equals(HttpMethod.OPTIONS)) {
            return request.createResponseBuilder(HttpStatus.OK).body("Function execution is possible")
                            .header("Access-Control-Request-Headers", "content-encoding,content-type,ocp-apim-subscription-key")
                            .header("Access-Control-Allow-Methods", "POST").build();
        } else {
            handleRequest(request.getBody().get(), context);

            return request.createResponseBuilder(HttpStatus.OK).body(handleRequest(request.getBody().get(), context)).build();
        }
    }
}
