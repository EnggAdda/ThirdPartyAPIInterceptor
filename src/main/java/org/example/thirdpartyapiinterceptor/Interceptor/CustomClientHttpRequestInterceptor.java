package org.example.thirdpartyapiinterceptor.Interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Log request details
        System.out.println("Request URI: " + request.getURI());
        System.out.println("Request Method: " + request.getMethod());
        System.out.println("Request Headers: " + request.getHeaders());

        // Execute the request
        ClientHttpResponse response  ;

        try {
           response = execution.execute(request, body);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Log the error or perform custom error handling
            System.err.println("Client or Server error occurred: " + e.getMessage());
            throw e;  // Rethrow the exception or wrap it in a custom exception
        } catch (IOException e) {
            // Handle network errors
            System.err.println("Network error occurred: " + e.getMessage());
            throw e;
        }
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders());

        return response;
    }

        // Log response details


}

