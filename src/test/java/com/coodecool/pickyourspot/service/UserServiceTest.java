package com.coodecool.pickyourspot.service;

import com.coodecool.pickyourspot.controller.UserController;
import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.UserDao;
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
    private UserDao userDao;
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
        userService = new UserService(userDao);
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
        when(userDao.getUserById(UUID.fromString("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002"))).thenReturn(Optional.ofNullable(user1));

        Optional<AppUser> user = userService.getUserById("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002");
        assertTrue(user.isPresent());
        assertEquals("Aniko Bradshow", user.get().getUsername());
    }

    @Test
    public void givenNotValidUserIdThenShouldReturnOptionalEmpty() {
        when(userDao.getUserById(UUID.fromString("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002"))).thenReturn(Optional.empty());
        Optional<AppUser> user = userService.getUserById("c8b2a7ba-7c5c-11ed-a1eb-0242ac120002");
        assertFalse(user.isPresent());
    }

    @Test
    public void givenGetAllUsersShouldReturnListOfAllUsers() {
        when(userDao.getAllUsers()).thenReturn(appUsers);
        List<AppUser> userList = userService.getAllUsers();
        assertEquals(2, userList.size());
        verify(userDao, times(1)).getAllUsers();
    }

    @Test
    public void ifUserRegistrationIsOkShouldReturnTrue() {
        when(userDao.getAllUsers()).thenReturn(appUsers);
        AppUser newUser = new AppUser(UUID.fromString("00000000-7c5c-11ed-a1eb-0242ac120002"), "Géza", "geza@email.com", "Geza");
        assertTrue(userService.registerUser(newUser));
    }
    @Test
    public void ifUserAlreadyRegisteredShouldReturnFalse() {
        when(userDao.getAllUsers()).thenReturn(appUsers);
        assertFalse(userService.registerUser(user1));
    }

    @Test
    public void checkIfUserInDbShouldReturnOptionalAppUser() {
        when(userDao.getAllUsers()).thenReturn(appUsers);
        Optional<AppUser> loggedInUser = userService.checkIfUserInDatabase(user1);
        assertTrue(loggedInUser.isPresent());
    }

    @Test
    public void checkNotValidUserShouldReturnOptionalEmpty() {
        AppUser newUser = new AppUser(UUID.fromString("00000000-7c5c-11ed-a1eb-0242ac120002"), "Géza", "geza@email.com", "Geza");
        when(userDao.getAllUsers()).thenReturn(appUsers);
        Optional<AppUser> loggedInUser = userService.checkIfUserInDatabase(newUser);
        assertFalse(loggedInUser.isPresent());
    }
}