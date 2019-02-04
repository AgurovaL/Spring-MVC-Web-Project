import dbService.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import viewModels.ViewBook;
import viewModels.ViewBuyingOperation;
import viewModels.ViewUser;

import java.util.List;

@RestController
@ComponentScan("api")
@Data
@NoArgsConstructor
public class RestApiController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBuyingOperationService buyingOperationService;

    @RequestMapping("/api/client")
    public ViewUser showUser(@RequestParam(value = "username", required = false, defaultValue = "guest") String username,
                             @RequestParam(value = "id", required = false, defaultValue = "0") long id) {
        ViewUser viewUser;
        if (username.equals("guest")) {
            if (id == 0) {
                return new
                        ViewUser(0L, "guest", null, null, null, null, "ROLE_USER");
            } else {
                return userService.findById(id);
            }
        } else {
            return userService.findByLogin(username);
        }
    }

    @RequestMapping("/api/clients")
    public List<ViewUser> showAllUsers() {
        List<ViewUser> viewUsersList = userService.findAll();
        return viewUsersList;
    }

    @RequestMapping("/api/book")
    public ViewBook showBook(@RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "id", required = false, defaultValue = "0") long id) {
        if (id == 0) {
            return new
                    ViewBook(0L, "default", null, null, 0, 0, 0, 0);
        } else {
            return bookService.findById(id);
        }
    }

    @RequestMapping("/api/books")
    public List<ViewBook> showAllBooks() {
        List<ViewBook> viewBooksList = bookService.findAll();
        return viewBooksList;
    }

    @RequestMapping("/api/operations")
    public List<ViewBuyingOperation> showAllOperations() {
        List<ViewBuyingOperation> viewOperationsList = buyingOperationService.findAll();
        return viewOperationsList;
    }
}

