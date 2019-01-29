package com.gzz;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.github.robwin.markup.builder.MarkupLanguage;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Swagger2DocsTest {

	@Autowired
	private MockMvc mockMvc;
	@Value("#{systemProperties['user.dir']}")
	private String userDir;

	/**
	 * 生成AsciiDoc文件
	 */
	@Test
//	@Ignore
	public void convertSwaggerToAsciiDoc() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/ascii").build()).andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * 生成MarkDown文件
	 */
	@Test
//	@Ignore
	public void convertSwaggerToMarkdown() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/markdown").withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * 生成Swagger.json
	 */
	@Test
	public void createSpringfoxSwaggerJson() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String path = userDir + "/src/docs/json/";
		Files.createDirectories(Paths.get(path));
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path, "swagger.json"), StandardCharsets.UTF_8)) {
			writer.write(mvcResult.getResponse().getContentAsString());
		}
	}
}
