package com.toluwase.appbackend;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.TodosRequest;
import com.toluwase.appbackend.models.UserRequest;
import com.toluwase.appbackend.models.Users;
import com.toluwase.appbackend.repositories.TodosRepository;
import com.toluwase.appbackend.repositories.UsersRepository;
import com.toluwase.appbackend.services.ServiceImpl.TodosServiceImpl;
import com.toluwase.appbackend.services.ServiceImpl.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppBackendApplicationTests {

    @Autowired
    private UsersServiceImpl usersServiceImpl;

    @Autowired
    private TodosServiceImpl todosService;

    @MockBean
    private UsersRepository usersRepository;

    @MockBean
    private TodosRepository todosRepository;


    @Test
    public void loginByEmailAndPasswordTest() {
        Users users = new Users();
        users.setFirstName("toluwase");
        users.setLastName("thomas");
        users.setUsername("toluwase");
        users.setPhoneNumber("09837645789");
        users.setEmail("tolu@gmail.com");
        users.setPassword("toluwase");
        Mockito.when(usersRepository.findByEmailAndPassword("tolu@gmail.com", "toluwase"))
                .thenReturn(users);
        assertEquals(users, usersServiceImpl.loginByEmail("tolu@gmail.com","toluwase"));
    }

    @Test
    public void loginByUserAndPasswordTest() {
        Users users = new Users();
        users.setFirstName("toluwase");
        users.setLastName("thomas");
        users.setUsername("toluwase");
        users.setPhoneNumber("09837645789");
        users.setEmail("tolu@gmail.com");
        users.setPassword("toluwase");
        Mockito.when(usersRepository.findByEmailAndPassword("toluwase", "toluwase"))
                .thenReturn(users);
        assertEquals(users, usersServiceImpl.loginByEmail("toluwase","toluwase"));
    }

    @Test
    public void signup() {
        Users users = new Users();
        users.setFirstName("toluwase");
        users.setLastName("thomas");
        users.setUsername("toluwase");
        users.setPhoneNumber("09837645789");
        users.setEmail("tolu@gmail.com");
        users.setPassword("toluwase");


        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("toluwase");
        userRequest.setLastName("thomas");
        userRequest.setUsername("toluwase");
        userRequest.setPhoneNumber("09837645789");
        userRequest.setEmail("tolu@gmail.com");
        userRequest.setPassword("toluwase");

        Mockito.when(usersRepository.save(users))
                .thenReturn(users);
        assertEquals(users, usersServiceImpl.signup(userRequest));
    }

    @Test
    public void getTodosList() {
        Todos todos = new Todos();
        todos.setTaskTitle("Write code");
        todos.setDescription("java, java, java");
//        todos.setStartDate(LocalDateTime.now());
//        todos.setFinishDate(LocalDateTime.now());
        todos.setId(2L);
        Mockito.when(todosRepository.findAll())
                .thenReturn((List<Todos>) todos);
        assertEquals(todos, todosService.listAllTodos());
    }

    @Test
    public void addTodos() throws Exception {

        Users users = new Users();
        users.setFirstName("toluwase");
        users.setLastName("thomas");
        users.setUsername("toluwase");
        users.setPhoneNumber("09837645789");
        users.setEmail("tolu@gmail.com");
        users.setPassword("toluwase");
        users.setId(1L);


        Todos todos = new Todos();
        todos.setTaskTitle("Write code");
        todos.setDescription("java, java, java");
//        todos.setStartDate(LocalDateTime.now());
//        todos.setFinishDate(LocalDateTime.now());
        todos.setId(2L);


        TodosRequest todosRequest = new TodosRequest();
        todosRequest.setTaskTitle("Write code");
        todosRequest.setDescription("java, java, java");
//        todosRequest.setStartDate(LocalDateTime.now());
//        todosRequest.setFinishDate(LocalDateTime.now());
//        todosRequest.setUserId(2L);


        Mockito.when(todosRepository.save(todos))
                .thenReturn(todos);
        assertEquals(todos, todosService.addTodos(todosRequest));
    }


}
