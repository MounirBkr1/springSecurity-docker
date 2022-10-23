package com.mnr.springsecurity_docker.init;

import com.mnr.springsecurity_docker.entities.Role;
import com.mnr.springsecurity_docker.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner  implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role roleUser= new Role(1L,"123","ROLE_USER");
        Role roleAdmin= new Role(2L,"456","ROLE_ADMIN");

        roleRepository.saveAll(asList(roleUser,roleAdmin));

    }
}
