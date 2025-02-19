package EdTech.Course.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/user/{id}")
        Object getUserById(@RequestHeader("Authorization") String token, @PathVariable Long id);

}
