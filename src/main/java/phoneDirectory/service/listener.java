package phoneDirectory.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import phoneDirectory.repository.PhoneRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Properties;

@Component
@AllArgsConstructor
public class listener implements ServletContextListener {
    private PhoneService phoneService;
    private PhoneRepository phoneRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        String poolConfig = sce.getServletContext().getInitParameter("connectionPoolConfiguration");
        System.out.println("제발돼라");

        phoneRepository.save(phoneService.getPhoneMap());
    }
}
