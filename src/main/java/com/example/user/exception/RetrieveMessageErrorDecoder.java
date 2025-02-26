package com.example.user.exception;//package com.example.user.error;
//
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.apache.coyote.BadRequestException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ResponseStatusException;
//
//public class RetrieveMessageErrorDecoder implements ErrorDecoder {
//
//    private final ErrorDecoder defaultErrorDecoder= new Default();
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        return switch (response.status()) {
//            case 400 -> new BadRequestException("Bad request from external service");
//            case 404 -> throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested resource not found");
//            default -> defaultErrorDecoder.decode(methodKey, response);
//        };
//
//    }
//}
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.apache.coyote.BadRequestException;
//
//
//import java.io.IOException;
//import java.io.InputStream;
//
//public class RetrieveMessageErrorDecoder implements ErrorDecoder {
//    private ErrorDecoder errorDecoder = new Default();
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        CustomExceptionMessage message = null;
//        try (InputStream bodyIs = response.body()
//                .asInputStream()) {
//            ObjectMapper mapper = new ObjectMapper();
//            message = mapper.readValue(bodyIs, CustomExceptionMessage.class);
//        } catch (IOException e) {
//            return new Exception(e.getMessage());
//        }
//        switch (response.status()) {
//            case 400:
//                return new BadRequestException(message.getMessage() != null ? message.getMessage() : "Bad Request");
//            case 404:
//                return new Exception(message.getMessage() != null ? message.getMessage() : "Not found");
//            default:
//                return errorDecoder.decode(methodKey, response);
//        }
//    }
//}

import com.example.user.dto.ProfileDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

public class RetrieveMessageErrorDecoder implements ErrorDecoder{

    private final ObjectMapper mapper=new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

    @Override
    public Exception decode(String methodKey, Response response) {
        try{
            ProfileDTO profile=mapper.readValue(response.body().asInputStream(), ProfileDTO.class);
            System.out.println(profile);
            return new CustomExceptionMessage(profile);
        }
        catch (Exception e){
            System.out.println("An unexpected error occurred");
        }
        return null;
    }
}

