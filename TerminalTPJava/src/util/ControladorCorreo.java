package util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ControladorCorreo {
	
	//private Correo c = new Correo();
	
	public boolean enviarCorreo(Correo c){
		try {
			Properties p = new Properties();
			//p.put("mail.smtp.host", "smtp.gmail.com");7


			p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			//p.put("mail.smtp.ssl.trust", "*");
			//p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
			p.setProperty("mail.smtp.auth", "true");
			
			Session s = Session.getDefaultInstance(p, null);
			BodyPart texto = new MimeBodyPart();
			texto.setText(c.getMensaje());
			/*
			BodyPart adjunto = new MimeBodyPart();
			
			if(!c.getRutaArchivo().equals("")) {
				adjunto.setDataHandler(  new DataHandler(  new FileDataSource(c.getRutaArchivo() ) ));
				adjunto.setFileName(c.getNombreArchivo());
			}
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);
			
			if(!c.getRutaArchivo().equals("")) {
				m.addBodyPart(adjunto);
			}
			*/
			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
			mensaje.setSubject(c.getAsunto());
			//mensaje.setContent(m);
			
			Transport t = s.getTransport("smtp");
			t.connect(c.getUsuarioCorreo(), c.getPassword());
			
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();
			
			return true;
			
		}catch(Exception e){
			
			System.out.println("Error lanzado por la excepcion en metodo enviar correo de la calse ControladorCorreo");
			return false;
		}
		
	}

}
