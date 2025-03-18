package com.tutorial.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TutorialApplicationTests {
	//using assertJ for the unit testing
	//we also have hamcrest and junit jupiter, which can also help write tests
	//we will also be using mockito for mock classes
	//these dependencies are all included in the spring boot starter test


	//creating an example test
	Calculator underTest = new Calculator();
	@Test
	void itShouldAddNumbers(){
		//given
		int numberOne = 10;
		int numberTwo = 30;

		//when
		int result = underTest.add(numberOne, numberTwo);

		//then
		//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
		//make sure that the package imported is the one above
		//checking that the result should be equal to 40
		assertThat(result).isEqualTo(40);

	}
	class Calculator{
		int add(int a, int b){
			return a+b;
		}
	}

}
