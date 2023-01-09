package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.controller.UserController;
import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.repositories.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserController userController;

//    @Autowired
    @InjectMocks
    private UserService userService;
    private AppUser user1;
    private AppUser user2;
    List<AppUser> appUsers;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository);
        appUsers = new ArrayList<>();
        user1 = new AppUser(UUID.fromString("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002"), "Aniko Bradshow", "aniko.bradshow@email.com", "AnikoBradshow79");
        user2 = new AppUser(UUID.randomUUID(), "Denes Donovan", "denes.donovan@email.com", "DenesDonovan90");
        appUsers.add(user1);
        appUsers.add(user2);
    }

    @AfterEach
    public void tearDown() {
        user1 = user2 = null;
        appUsers = null;
    }

    @Test
    public void givenUserIdThenShouldReturnUserOfThatId() {
        when(userRepository.findById(UUID.fromString("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002"))).thenReturn(Optional.ofNullable(user1));

        Optional<AppUser> user = userService.getUserById("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002");
        assertTrue(user.isPresent());
        assertEquals("Aniko Bradshow", user.get().getUsername());
    }

    @Test
    public void givenNotValidUserIdThenShouldReturnOptionalEmpty() {
        when(userRepository.findById(UUID.fromString("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002"))).thenReturn(Optional.empty());
        Optional<AppUser> user = userService.getUserById("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002");
        assertFalse(user.isPresent());
    }

    @Test
    public void givenGetAllUsersShouldReturnListOfAllUsers() {
        when(userRepository.findAll()).thenReturn(appUsers);
        List<AppUser> userList = userService.getAllUsers();
        assertEquals(2, userList.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void ifUserRegistrationIsOkShouldReturnTrue() {
        when(userRepository.findAll()).thenReturn(appUsers);
        AppUser newUser = new AppUser(UUID.fromString("00000000-7c5c-11ed-a1eb-0242ac120002"), "Géza", "geza@email.com", "Geza");
        assertTrue(userService.registerUser(newUser));
    }
    @Test
    public void ifUserAlreadyRegisteredShouldReturnFalse() {
        when(userRepository.findAll()).thenReturn(appUsers);
        assertFalse(userService.registerUser(user1));
    }

    @Test
    public void checkIfUserInDbShouldReturnOptionalAppUser() {
        when(userRepository.findAll()).thenReturn(appUsers);
        Optional<AppUser> loggedInUser = userService.checkIfUserInDatabase(user1);
        assertTrue(loggedInUser.isPresent());
    }

    @Test
    public void checkNotValidUserShouldReturnOptionalEmpty() {
        AppUser newUser = new AppUser(UUID.fromString("00000000-7c5c-11ed-a1eb-0242ac120002"), "Géza", "geza@email.com", "Geza");
        when(userRepository.findAll()).thenReturn(appUsers);
        Optional<AppUser> loggedInUser = userService.checkIfUserInDatabase(newUser);
        assertFalse(loggedInUser.isPresent());
    }
}