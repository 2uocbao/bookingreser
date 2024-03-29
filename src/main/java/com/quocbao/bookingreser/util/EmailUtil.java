package com.quocbao.bookingreser.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	private JavaMailSender javaMailSender;

	public void sendOtpEmail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Verify OTP");
		mimeMessageHelper.setText(
				"""
						<div>
						  <a href="http://localhost:9090/verify-account?email=%s&otp=%s" target="_blank">click link to verify</a>
						</div>
						"""
						.formatted(email, otp),
				true);

		javaMailSender.send(mimeMessage);
	}

}
