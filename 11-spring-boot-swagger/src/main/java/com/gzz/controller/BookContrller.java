package com.gzz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
@RequestMapping(value = "/books")
@Api(tags = "枚举字典")
public class BookContrller {

	Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

	@ApiOperation(value = "获取图书列表", notes = "获取图书列表")
	@GetMapping
	public List<Book> getBook() {
		List<Book> book = new ArrayList<>(books.values());
		return book;
	}

	@ApiOperation(value = "创建图书", notes = "创建图书")
	@ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
	@PostMapping
	public String postBook(@RequestBody Book book) {
		books.put(book.getId(), book);
		return "success";
	}

	@ApiOperation(value = "获图书细信息", notes = "根据url的id来获取详细信息")
	@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return books.get(id);
	}

	@ApiOperation(value = "更新信息", notes = "根据url的id来指定更新图书信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer", paramType = "path"),
			@ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @RequestBody Book book) {
		Book book1 = books.get(id);
		book1.setName(book.getName());
		book1.setPrice(book.getPrice());
		books.put(id, book1);
		return "success";
	}

	@ApiOperation(value = "删除图书", notes = "根据url的id来指定删除图书")
	@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		books.remove(id);
		return "success";
	}

//	@ApiIgnore // 使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest(HttpServletRequest  request) {
		String token = request.getHeader("token");
		
		return " hi you!"+token;
	}
}
