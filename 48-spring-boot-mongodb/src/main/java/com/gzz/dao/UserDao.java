package com.gzz.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gzz.model.User;

import java.util.List;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public interface UserDao extends MongoRepository<User, Long> {

	/**
	 * Like（模糊查询） {"username" : name} ( name as regex)
	 */
	List<User> findByUsernameLike(String username);

	/**
	 * Like（模糊查询） {"username" : name}
	 */
	List<User> findByUsername(String username);

	/**
	 * GreaterThan(大于) {"age" : {"$gt" : age}}
	 */
	List<User> findByAgeGreaterThan(int age);

	/**
	 * LessThan（小于） {"age" : {"$lt" : age}}
	 */
	List<User> findByAgeLessThan(int age);

	/**
	 * Between（在...之间） {{"age" : {"$gt" : from, "$lt" : to}}
	 */
	List<User> findByAgeBetween(int from, int to);

	/**
	 * IsNotNull, NotNull（是否非空） {"username" : {"$ne" : null}}
	 */
	List<User> findByUsernameNotNull();

	/**
	 * IsNull, Null（是否为空） {"username" : null}
	 */
	List<User> findByUsernameNull();

	/**
	 * Not（不包含） {"username" : {"$ne" : name}}
	 */
	List<User> findByUsernameNot(String name);

	/**
	 * Near（查询地理位置相近的） {"location" : {"$near" : [x,y]}}
	 */
	// findByLocationNear(Point point)

	/**
	 * Within（在地理位置范围内的） {"location" : {"$within" : {"$center" : [ [x, y],
	 * distance]}}}
	 */
	// findByLocationWithin(Circle circle)

	/**
	 * Within（在地理位置范围内的） {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
	 */
	// findByLocationWithin(Box box)

	@Query("{\"username\":{\"$regex\":?0}, \"age\": ?1}")
	Page<User> findByNameAndAgeRange(String name, int age, Pageable page);

	@Query(value = "{\"username\":{\"$regex\":?0},\"age\":{\"$gte\":?1,\"$lte\": ?2}}")
	Page<User> findByNameAndAgeRange2(String name, int ageFrom, int ageTo, Pageable page);

	@Query(value = "{\"username\":{\"$regex\":?0},\"age\":{\"$gte\":?1,\"$lte\": ?2}}", fields = "{\"username\" : 1, \"age\" : 1}")
	Page<User> findByNameAndAgeRange3(String name, int ageFrom, int ageTo, Pageable page);

}
