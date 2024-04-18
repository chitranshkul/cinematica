package com.esdproject.academiq;

import com.esdproject.academiq.Courses.Courses;
import com.esdproject.academiq.Courses.CoursesRepositry;
import com.esdproject.academiq.auth.AuthenticationService;
import com.esdproject.academiq.auth.RegisterRequest;
import com.esdproject.academiq.department.Department;
import com.esdproject.academiq.department.DepartmentRepository;
import com.esdproject.academiq.employee.Employee;
import com.esdproject.academiq.employee.EmployeeRepository;
import com.esdproject.academiq.user.Role;
import com.esdproject.academiq.user.User;
import com.esdproject.academiq.user.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AcademIQApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademIQApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			DepartmentRepository departmentRepository,

			EmployeeRepository employeeRepository,
			CoursesRepositry coursesRepositry,
			AuthenticationService authService
	) {

		return args -> {

			try {

				//Create departments
				Department department1 = Department.builder().name("CSE").capacity(50).build();
				Department department2 = Department.builder().name("ESE").capacity(30).build();

				departmentRepository.save(department1);
				departmentRepository.save(department2);

				// Create users

				var user1 = RegisterRequest.builder()
						.firstname("Chitransh")
						.lastname("Kulshrestha")
						.email("chitransh.kulshrestha@iiitb.ac.in")
						.password("1234")
						.role(Role.EMPLOYEE).build();


				var user2 = RegisterRequest.builder()
						.firstname("Keshav")
						.lastname("Aggarwal")
						.email("keshav.aggarwal@iiitb.ac.in")
						.password("1234")
						.role(Role.EMPLOYEE).build();


				var user3 = RegisterRequest.builder()
						.firstname("Adarsh Tripathi")
						.email("adarsh.tripathi@iiitb.ac.in")
						.password("1234")
						.role(Role.EMPLOYEE).build();

				var user4 = RegisterRequest.builder()
						.firstname("Swarnim Kukreti")
						.email("swarnim.kukreti@iiitb.ac.in")
						.password("1234")
						.role(Role.EMPLOYEE).build();

				var user5 = RegisterRequest.builder()
						.firstname("Vicky")
						.lastname("Panchal")
						.email("vicky@gmail.com")
						.password("1234")
						.role(Role.EMPLOYEE).build();

				var user6 = RegisterRequest.builder()
						.firstname("Parag ")
						.lastname("Dutt Sharma")
						.email("parag.dutt.sharma@gmail.com")
						.password("1234")
						.role(Role.EMPLOYEE).build();


				authService.register(user1);
				authService.register(user2);
				authService.register(user3);
				authService.register(user4);
				authService.register(user5);
				authService.register(user6);

				User user11 = userRepository.findById(1).orElse(null);
				User user22 = userRepository.findById(2).orElse(null);
				User user33 = userRepository.findById(3).orElse(null);
				User user44 = userRepository.findById(4).orElse(null);
				User user55 = userRepository.findById(5).orElse(null);
				User user66 = userRepository.findById(6).orElse(null);

				if(user11 != null && user22 != null && user33 != null && user44 != null && user55 != null && user66 != null) {

					Employee employee1 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user11).department(department1).first_name("Chitransh").last_name("Kulshrestha").email("chitransh.kulshrestha@iiitb.ac.in").build();
					Employee employee2 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user22).department(department1).first_name("Keshav").last_name("Aggrwal").email("keshav.aggrwal@iiitb.ac.in").build();
					Employee employee3 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user33).department(department1).first_name("Adarsh").last_name("Tripathi").email("adash.tripathi@iiitb.ac.in").build();
					Employee employee4 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user44).department(department1).first_name("swarnim").last_name("kukreti").email("swarnim.kukreti@iiitb.ac.in").build();
					Employee employee5 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user55).department(department1).first_name("Vcky").last_name("Panchal").email("vicky.panchal@iiitb.ac.in").build();
					Employee employee6 = Employee.builder().title("Professor").photographPath("/path/to/photo3.jpg").user(user66).department(department1).first_name("Parag").last_name("Dutt Sharma").email("parag.dutt.sharma@iiitb.ac.in").build();


					employeeRepository.save(employee1);
					employeeRepository.save(employee2);
					employeeRepository.save(employee3);
					employeeRepository.save(employee4);
					employeeRepository.save(employee5);
					employeeRepository.save(employee6);



					Courses course11 = Courses.builder().employee(employee1).course_code("CS101").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course12 = Courses.builder().employee(employee1).course_code("AI101").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course13 = Courses.builder().employee(employee1).course_code("CS102").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course14 = Courses.builder().employee(employee1).course_code("CS103").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course15 = Courses.builder().employee(employee1).course_code("AI104").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course16 = Courses.builder().employee(employee1).course_code("AI105").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();


					Courses course21 = Courses.builder().employee(employee2).course_code("CS202").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course22 = Courses.builder().employee(employee2).course_code("AI201").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course23 = Courses.builder().employee(employee2).course_code("CS207").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course24 = Courses.builder().employee(employee2).course_code("CS203").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course25 = Courses.builder().employee(employee2).course_code("AI212").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course26 = Courses.builder().employee(employee2).course_code("AI231").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();

					Courses course31 = Courses.builder().employee(employee3).course_code("CS301").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course32 = Courses.builder().employee(employee3).course_code("AI301").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course33 = Courses.builder().employee(employee3).course_code("CS302").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course34 = Courses.builder().employee(employee3).course_code("CS303").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course35 = Courses.builder().employee(employee3).course_code("AI312").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course36 = Courses.builder().employee(employee3).course_code("AI331").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();

					Courses course41 = Courses.builder().employee(employee4).course_code("CS401").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course42 = Courses.builder().employee(employee4).course_code("AI401").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course43 = Courses.builder().employee(employee4).course_code("CS402").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course44 = Courses.builder().employee(employee4).course_code("CS403").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course45 = Courses.builder().employee(employee4).course_code("AI412").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course46 = Courses.builder().employee(employee4).course_code("AI431").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();

					Courses course51 = Courses.builder().employee(employee5).course_code("CS501").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course52 = Courses.builder().employee(employee5).course_code("AI501").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course53 = Courses.builder().employee(employee5).course_code("CS502").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course54 = Courses.builder().employee(employee5).course_code("CS503").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course55 = Courses.builder().employee(employee5).course_code("AI512").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course56 = Courses.builder().employee(employee5).course_code("AI531").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();

					Courses course61 = Courses.builder().employee(employee6).course_code("CS601").capcity("100").credits("4").name("NO SQL").term("Jan-Juy").year("").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course62 = Courses.builder().employee(employee6).course_code("AI601").capcity("100").credits("4").name("Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course63 = Courses.builder().employee(employee6).course_code("CS602").capcity("100").credits("4").name("ESD").term("").year("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();
					Courses course64 = Courses.builder().employee(employee6).course_code("CS603").capcity("100").credits("4").name("DBMS").term("Jan-Juy").year("July-Dec").year("2023-24").description("NoSQL, short for Not Only SQL, refers to a class of database management systems (DBMS) that deviate from the traditional relational database model. Unlike traditional SQL databases, NoSQL databases are designed to handle a variety of data types and structures, offering flexibility, scalability, and high performance in managing vast amounts of unstructured or semi-structured data.").build();
					Courses course65 = Courses.builder().employee(employee6).course_code("AI612").capcity("100").credits("4").name("Maths For Machine Learning").term("Jan-Juy").year("2023-24").description("Machine Learning (ML) is a branch of artificial intelligence (AI) that involves the development of algorithms and models that enable computers to learn and improve from experience without being explicitly programmed. The primary goal of machine learning is to create systems that can autonomously learn from data and make predictions or decisions based on that learning.").build();
					Courses course66 = Courses.builder().employee(employee6).course_code("AI631").capcity("100").credits("4").name("Natural Language Processing").term("Jan-Juy").year("2023-24").description("Enterprise Software Development refers to the process of creating software applications specifically designed to meet the needs of large-scale organizations or businesses. These applications are developed to support complex business processes, improve efficiency, streamline operations, and facilitate communication within and between different departments or branches of an enterprise.").build();

					coursesRepositry.save(course11);
					coursesRepositry.save(course12);
					coursesRepositry.save(course13);
					coursesRepositry.save(course14);
					coursesRepositry.save(course15);
					coursesRepositry.save(course16);

					coursesRepositry.save(course21);
					coursesRepositry.save(course22);
					coursesRepositry.save(course23);
					coursesRepositry.save(course24);
					coursesRepositry.save(course25);
					coursesRepositry.save(course26);

					coursesRepositry.save(course31);
					coursesRepositry.save(course32);
					coursesRepositry.save(course33);
					coursesRepositry.save(course34);
					coursesRepositry.save(course35);
					coursesRepositry.save(course36);

					coursesRepositry.save(course41);
					coursesRepositry.save(course42);
					coursesRepositry.save(course43);
					coursesRepositry.save(course44);
					coursesRepositry.save(course45);
					coursesRepositry.save(course46);

					coursesRepositry.save(course51);
					coursesRepositry.save(course52);
					coursesRepositry.save(course53);
					coursesRepositry.save(course54);
					coursesRepositry.save(course55);
					coursesRepositry.save(course56);

					coursesRepositry.save(course61);
					coursesRepositry.save(course62);
					coursesRepositry.save(course63);
					coursesRepositry.save(course64);
					coursesRepositry.save(course65);
					coursesRepositry.save(course66);

				}


				// Save employees
				// (Remember to save employeeSalary entries if needed)


			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		};
	}
}
