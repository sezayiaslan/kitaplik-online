package com.kitaplik.libraryservice.client;

import com.kitaplik.libraryservice.exception.BookNotFoundException;
import com.kitaplik.libraryservice.exception.ExceptionMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage exceptionMessage = null;

        try(InputStream inputStream = response.body().asInputStream()){
            exceptionMessage = new ExceptionMessage((String) response.headers().get("data").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(inputStream, StandardCharsets.UTF_8),
                    response.request().url());

        }catch (IOException ioException){

        }

        switch (response.status()){
            case 404:
                throw new BookNotFoundException(exceptionMessage);
            default:
                errorDecoder.decode(methodKey,response);

        }

        return null;
    }
}
