package com.spring.fundamentos;

import com.spring.fundamentos.bean.MyBean;

import com.spring.fundamentos.bean.MyBeanWithDependency;
import com.spring.fundamentos.bean.MyBeanWithProperties;
import com.spring.fundamentos.component.ComponentDependency;
import com.spring.fundamentos.entity.User;
import com.spring.fundamentos.pojo.UserPojo;
import com.spring.fundamentos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		//ejemplosAnteriores();
		saveUserSinDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
//		LOGGER.info("aca esta el user del mail: " +
//				userRepository.findByUserEmail("john@domain.com")
//						.orElseThrow(() -> new RuntimeException("no se encontro ese mail") ));
//		userRepository.findAndSort("john", Sort.by("id")
//				.descending())
//				.forEach(user-> LOGGER.info("usuario con metodo sort" + user));
//		userRepository.findByName("John")
//				.forEach(user -> LOGGER.info("usuario con query method" + user));
//		LOGGER.info("usuario con query method findByEmailAndName " + userRepository.findByEmailAndName("enrique@domain.com", "Enrique")
//				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
//
//		userRepository.findByNameLike("%u%") /* % % (se utiliza para hacer una especificacion en la busqueda */
//				.forEach(user ->LOGGER.info("usuario con findByNameLike " + user));
//
//		userRepository.findByNameOrEmail("John", null)
//				.stream()
//				.forEach(user ->LOGGER.info("usuario con findByNameOrEmail " + user));
//		userRepository.findByBirthDateBetween(LocalDate.of(2021,3,1), LocalDate.of(2021,5,5))
//				.stream()
//				.forEach(user -> LOGGER.info("Usuarios entre estas fechas " + user));
//
//		userRepository.findAllOrderByIdDesc("%user%")
//				.stream()
//				.forEach(user -> LOGGER.info("Lista de users descendiente" + user));

		LOGGER.info("El nombre a partir del named parameter es: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 9, 8),
						"daniela@domain.com")
				.orElseThrow(() -> new RuntimeException("no se encuentra el usuario con ese named parameter")));
	}


	private void saveUserSinDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("John", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		List<User> list = Arrays.asList(user1,user8,user7,user6,user5,user4,user3,user2,user9);
		list.stream().forEach(userRepository::save);
	}
	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "- " + userPojo.getPass());
	}
}
