import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import viewModels.UserAccount;
import viewModels.ViewBook;
import viewModels.ViewUser;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static viewModels.UIConstants.PagesURLs.*;
import static viewModels.UIConstants.UserAccountAttributes.*;
import static viewModels.UIConstants.ViewUserAttributes.*;

@Controller
@Data
@NoArgsConstructor
public class MainController {

    @GetMapping({REGISTRATION_URL})
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(REGISTRATION_URL, VIEW_USER, new ViewUser());
    }

    //объявление spring validator
    @Autowired
    @Qualifier(VIEW_USER_VALIDATOR)
    private Validator viewUserValidator;

    //Аннотация @Valid инициализирует проверку данных
    //В этом случае выполнится только spring проверка, декларативные проверки (типа @Null, @Email и тд) будут проигнорированы
    @PostMapping({REGISTER_URL})
    public String register(@Valid @ModelAttribute(VIEW_USER) ViewUser viewUser,
                           BindingResult result, ModelMap model) {
        // spring validate
        viewUserValidator.validate(viewUser, result);

        //если есть ошибки
        if (result.hasErrors()) {
            showErrors(result, model);
            return REGISTRATION_URL;
        }

        //userService.save(viewUser);

        model.addAttribute(FIRST_NAME, viewUser.getFirstName());
        model.addAttribute(LAST_NAME, viewUser.getLastName());
        model.addAttribute(ADDRESS, viewUser.getAddress());
        model.addAttribute(VIEW_LOGIN, viewUser.getLogin());
        model.addAttribute(VIEW_PASSWORD, viewUser.getPassword());

        return USER_PROFILE_URL;
    }

    @GetMapping({LOGIN_URL})
    public ModelAndView showLoginPage() {
        return new ModelAndView(LOGIN_URL, USER_ACCOUNT, new UserAccount());
    }

    @Autowired
    @Qualifier(USER_ACCOUNT_VALIDATOR)
    private Validator userAccountValidator;

    @PostMapping({LOGIN_URL})
    public String login(@Valid @ModelAttribute(USER_ACCOUNT) UserAccount userAccount,
                        BindingResult result, ModelMap model) {
        // spring validate
        userAccountValidator.validate(userAccount, result);

        if (result.hasErrors()) {
            showErrors(result, model);
            return LOGIN_URL;
        }

        //UserAccount checkAccount = userService.findUserByLogin(userAccount.getLogin());
//        if (!checkAccount.equals(userAccount)){
//            model.addAttribute("errorMessage", "no such user");
//            return LOGIN_URL;
//        }

        model.addAttribute(ACCOUNT_LOGIN, userAccount.getLogin());
        return USER_PROFILE_URL;

    }

    //вывести сообщение об ошибке возле нужного поля
    private void showErrors(BindingResult result, ModelMap model) {
        List<ObjectError> errorsList = result.getAllErrors();

        for (ObjectError objectError : errorsList) {
            FieldError fieldError = null;
            if (objectError instanceof FieldError) {
                fieldError = (FieldError) objectError;

                model.addAttribute(fieldError.getField(), fieldError.getCode());
            }
        }
    }

    @GetMapping(SHOW_USERS_URL)
    public String usersGet(Model model) {
        List<ViewUser> userList = new ArrayList<>();
        //userService.findAllUsers();
        userList.add(new ViewUser(1L, "Jon", "Snow", "Black Castle", "jon", "jonsnow1"));
        model.addAttribute("users", userList);
        model.addAttribute(ACCOUNT_LOGIN, "ADMIN");
        return SHOW_USERS_URL;
    }

    @GetMapping(SHOW_BOOKS_URL)
    public String booksGet(Model model) {
        List<ViewBook> bookList = new ArrayList<>();
        //bookService.findAllBooks();
        bookList.add(new ViewBook(1L,"The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300));
        bookList.add(new ViewBook(2L,"Witches Abroad", "T. Pratchett", "Sun", 1991, 2003, 260));
        model.addAttribute("books", bookList);
        model.addAttribute(ACCOUNT_LOGIN, "GUEST");
        return SHOW_BOOKS_URL;
    }
}
