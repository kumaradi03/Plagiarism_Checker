package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author mrunal
 * To check functionality of SendEmail
 *
 */
public class SendEmailTests {

	/**
	 * Try Sending an Email. 
	 */
	@Test
	public void TestforSendEmail() {
		SendEmail.getInstance("Team-102, This is Test mail to check if Test functionality works well. \n Have A Good Day !! ");
	}

}
