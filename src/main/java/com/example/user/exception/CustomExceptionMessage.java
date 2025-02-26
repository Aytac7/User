package com.example.user.exception;

import com.example.user.dto.ProfileDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionMessage extends RuntimeException{
   private  ProfileDTO profile;

public CustomExceptionMessage (ProfileDTO profile) {
   this.profile=profile;
   }
}

