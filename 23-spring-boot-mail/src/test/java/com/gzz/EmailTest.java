package com.gzz;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("163")
public class EmailTest {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String Sender;

//    @Test
	public void sendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(Sender);
		message.setTo("38967098@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);
	}

//    @Test
	public void sendHtmlMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(Sender);
			helper.setSubject("主题：HTML邮件");

			StringBuffer sb = new StringBuffer();
			sb.append("<h1>大标题-h1</h1>").append("<p style='color:#F00'>红色字</p>")
					.append("<p style='text-align:right'>右对齐</p>");
			helper.setText(sb.toString(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}

//    @Test
	public void sendAttachmentsMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(Sender);
			helper.setSubject("主题：带附件的邮件");
			helper.setText("带附件的邮件内容");
			// 注意项目路径问题，自动补用项目路径
			FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
			// 加入邮件
			helper.addAttachment("图片.jpg", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}

	@Test
	public void sendTemplateMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(Sender);
			helper.setSubject("主题：模板邮件");
			Map<String, Object> model = new HashMap<>();
			model.put("username", "zggdczfr");
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setClassForTemplateLoading(this.getClass(), "/templates");
			Template template = cfg.getTemplate("mail.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			helper.setText(html, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
