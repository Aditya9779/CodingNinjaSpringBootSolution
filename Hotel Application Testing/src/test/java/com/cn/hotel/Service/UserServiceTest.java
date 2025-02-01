package com.cn.hotel.Service;

import com.cn.hotel.repository.UserRepository;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    
}
