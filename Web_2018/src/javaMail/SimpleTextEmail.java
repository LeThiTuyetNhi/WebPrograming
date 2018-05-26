package javaMail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleTextEmail {

	public static boolean sendMail(String to, String subject, String text) {
		String email = "tieuyet.tieuyet.nl@gmail.com";
		String password = "Nhile01642335255";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/html; charset=UTF-8");
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent(text, "text/html; charset=UTF-8");
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
//	
//	public static void main(String[] args) {
//		System.out.println(sendMail("15130130@st.hcmuaf.edu.vn", "Test", "<img src=\"https://www.google.com/a/st.hcmuaf.edu.vn/images/logo.gif?alpha=1&service=google_default\"/>"));
//		
//
//	}
}