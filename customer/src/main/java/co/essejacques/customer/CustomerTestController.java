package co.essejacques.customer;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("")
@Tag(name = "customers test", description = "customers API test")
public class CustomerTestController {

    private final CustomerService customerService;

    @GetMapping
    public String test() {
        return "test";
    }
}
