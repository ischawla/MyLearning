package com.io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
@RunWith(SpringRunner.class)
@SpringBootTest
class MathUtilsTest2 {
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUserTest() {
		when.(repository.findAll()).thenReturn(Stream.of(new User(376,"Dani",31,"USA") , new User(425,"Rani",28,"India")).collect(Collectors.toList()) );
		assertEquals(2,service.getUsers().size());
	}
	
	
	@Test
	public void getUserByAddressTest() {
	String address = "Raipur";
	when(respository.findByAdress()).thenReturn(Stream.of(new User(376,"Dani",31,"USA")).collect(Collectors.toList()));
	assertEquals(1,service.getUserbyAddress().size());
	}
	
	@Test
	public void saveUserTest() {
		User user  = new User(478,"Robin",56,"UK");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));
	}
	
	
	@Test
	public void deleteUserTest() {
		User user = new User(478,"Robin",56,"UK");
		service.deleteUser(user); //Since this method return VOID we cant use assert method. To verify we can check if our method is called or not
		verify(repository,times(1)).delete(user);
	}
}
