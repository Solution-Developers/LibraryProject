package com.example.LibraryProject;

import com.example.LibraryProject.entity.enums.RoleType;
import com.example.LibraryProject.entity.user.Role;
import com.example.LibraryProject.payload.user.UserRequest;
import com.example.LibraryProject.repository.user.RoleRepository;
import com.example.LibraryProject.service.user.RoleService;
import com.example.LibraryProject.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryProjectApplication implements CommandLineRunner {


	private final RoleRepository roleRepository;
	private final RoleService roleService;
	private final UserService userService;

	public LibraryProjectApplication(RoleService roleService,RoleRepository roleRepository,
									UserService userService){
		this.roleService=roleService;
		this.roleRepository=roleRepository;
		this.userService=userService;
	}


	public static void main(String[] args) {

		SpringApplication.run(LibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (roleService.getAllUserRole().isEmpty()){

			Role admin= new Role();
			admin.setRoleName(RoleType.ADMIN);
			admin.setName("Admin");
			roleRepository.save(admin);

			Role employee= new Role();
			admin.setRoleName(RoleType.EMPLOYEE);
			admin.setName("Employee");
			roleRepository.save(employee);

			Role member= new Role();
			admin.setRoleName(RoleType.MEMBER);
			admin.setName("Member");
			roleRepository.save(member);

			Role anonymous= new Role();
			admin.setRoleName(RoleType.ANONYMOUS);
			admin.setName("Anonymous");
			roleRepository.save(anonymous);

		}

		if (roleService.countAllAdmins()==0){

			UserRequest admin=new UserRequest();
			admin.setFirstName("Songul");
			admin.setLastName("Celik");
			admin.setScore(0);
			admin.setAddress("Izmir");
			admin.setPhone("05005005050");
			admin.setEmail("abc@gmail.com");
			admin.setPassword("123456789");

			userService.createUser(admin,"Admin");
		}


	}
}
