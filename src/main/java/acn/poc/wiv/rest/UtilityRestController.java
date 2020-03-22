package acn.poc.wiv.rest;


import acn.poc.wiv.entity.Event;
import acn.poc.wiv.entity.Role;
import acn.poc.wiv.entity.User;
import acn.poc.wiv.service.EventService;
import acn.poc.wiv.service.RoleService;
import acn.poc.wiv.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@CrossOrigin
@RequestMapping("/util")
public class UtilityRestController {

    private UserService userService;
    private EventService eventService;
    private RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UtilityRestController.class);

    @Autowired
    public UtilityRestController(UserService userService, EventService eventService, RoleService roleService) {

        this.userService = userService;
        this.eventService = eventService;
        this.roleService = roleService;
    }

    @GetMapping("/seed-db")
    public Boolean populateDatabaseWithTestData() {

        logger.info("START populateDatabaseWithTestData...");

        /* Roles */
        Role sanepidUser = new Role();
        sanepidUser.setName("ROLE_SANEPID");

        Role registeredUser = new Role();
        registeredUser.setName("ROLE_REGISTERED_USER");

        User user1 = new User();
        user1.setEmail("sanepid.waw@example.com");
        user1.setFullName("Karol Krawczyk");
        user1.setNickName("KrawczykMPK");
        user1.setPassword("pk1");
        user1.addRole(sanepidUser);

        User user2 = new User();
        user2.setEmail("janek.kowalski@example.com");
        user2.setFullName("Jan Kowalski");
        user2.setNickName("Janko");
        user2.setPassword("pk2");
        user2.addRole(sanepidUser);

        User user3 = new User();
        user3.setEmail("alicja.kotak@example.com");
        user3.setFullName("Alicja Kotak");
        user3.setNickName("Kotak");
        user3.setPassword("pk3");
        user3.addRole(sanepidUser);

        User user4 = new User();
        user4.setEmail("adam.walter@example.com");
        user4.setFullName("Adam Walter");
        user4.setNickName("Adas");
        user4.setPassword("pk4");
        user4.addRole(sanepidUser);

        User user5 = new User();
        user5.setEmail("ola.wasiak@example.com");
        user5.setFullName("Ola Wasiak");
        user5.setNickName("Ola");
        user5.setPassword("pk5");
        user5.addRole(registeredUser);

        User user6 = new User();
        user6.setEmail("marzena.kowal@example.com");
        user6.setFullName("Marzenia Kowal");
        user6.setNickName("Marzenka");
        user6.setPassword("pk6");
        user6.addRole(registeredUser);

        Event event1 = new Event();
//        event1.setCreator(user1);
        event1.setConfirmedBySanepid(true);
        event1.setCreationDate(LocalDateTime.now());
        event1.setDescription("Confirmed case, woman age 36");
        event1.setLastUpdateDate(LocalDateTime.now());
        event1.setOccurrenceDate(LocalDateTime.now().minusDays(2));
        event1.setLongitude(21.2314335);
        event1.setLatitude(52.3241234);
        event1.setHasCough(true);
        event1.setHasFever(true);
        event1.setHasShortnessBreath(false);
        event1.setInQuarantine(true);
        event1.setAddress( "Saska 16 Street, Warsaw");

        Event event2 = new Event();
//        event2.setCreator(user1);
        event2.setConfirmedBySanepid(true);
        event2.setCreationDate(LocalDateTime.now());
        event2.setDescription("Confirmed case, Man, 46 age, teacher");
        event2.setLastUpdateDate(LocalDateTime.now());
        event2.setOccurrenceDate(LocalDateTime.now().minusDays(3));
        event2.setLongitude(18.2314335);
        event2.setLatitude(50.2341235);
        event2.setHasCough(false);
        event2.setHasFever(false);
        event2.setHasShortnessBreath(false);
        event2.setInQuarantine(false);
        event2.setAddress("WUM Hospital, Warsaw");


        Event event3 = new Event();
//        event3.setCreator(user2);
        event3.setConfirmedBySanepid(false);
        event3.setCreationDate(LocalDateTime.now());
        event3.setDescription("Not confirmed by test, recently travelled abroad");
        event3.setLastUpdateDate(LocalDateTime.now());
        event3.setOccurrenceDate(LocalDateTime.now().minusDays(4));
        event3.setLongitude(22.2314335);
        event3.setLatitude(53.2341235);
        event3.setHasCough(true);
        event3.setHasFever(true);
        event3.setHasShortnessBreath(true);
        event3.setInQuarantine(true);
        event3.setAddress("Bacha 45 Street, Warsaw ");

        user1.addCreatedEvent(event1);
        user1.addCreatedEvent(event2);
        user2.addCreatedEvent(event3);
        user3.addConfirmedEvent(event1);
        user3.addConfirmedEvent(event2);

        eventService.save(event1);
        eventService.save(event2);
        eventService.save(event3);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);

        logger.info("END populateDatabaseWithTestData...");
        return Boolean.TRUE;
    }
}
