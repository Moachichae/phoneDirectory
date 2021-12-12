package phoneDirectory.config;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import phoneDirectory.repository.PhoneRepository;
import phoneDirectory.service.PhoneService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Properties;

@Service
@AllArgsConstructor
public class listener implements ApplicationListener<ContextClosedEvent> {
    //spring server가 정상종료될때메소드 한번 실행
    private final PhoneService phoneService;
    private final PhoneRepository phoneRepository;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        phoneRepository.save(phoneService.getPhoneMap());
    }
}
