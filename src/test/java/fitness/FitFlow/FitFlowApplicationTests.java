package fitness.FitFlow;

import fitness.FitFlow.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.when;

@SpringBootTest
class FitFlowApplicationTests {


	@MockitoBean
	UserService userService;


	@Test
	void testGetUser(){
		when(userService.getUsers(ArgumentMatchers.anyString())).thenReturn("Ram Ji");

		Assertions.assertNotNull(userService.getUsers("Ram Ji"));
	}



}
