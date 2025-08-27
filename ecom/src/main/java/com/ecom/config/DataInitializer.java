package com.ecom.config;
import com.ecom.entity.User;
import com.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByEmail("admin") == null) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            userRepo.save(admin);
            System.out.println("Default admin created -> Username: admin, Password: admin123");
        }
    }
}
