package com.springboot.spring.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessageM extends Base{
    private static final long serialVersionUID = 1L;
	private String errMessage;
	private String errCode;
    private Throwable errorDetails;
	
    private Date date;
    
}
