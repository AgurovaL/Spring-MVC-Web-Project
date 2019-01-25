import dbService.BookService;
import dbService.BuyingOperationService;
import dbService.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import viewModels.ViewBook;
import viewModels.ViewBuyingOperation;
import viewModels.ViewUser;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static viewModels.UIConstants.ModelAttributes.*;
import static viewModels.UIConstants.OperationAttributes.*;
import static viewModels.UIConstants.PagesURLs.*;
import static viewModels.UIConstants.Roles.ROLE_USER;
import static viewModels.UIConstants.UserAccountAttributes.ACCOUNT_LOGIN;

@Controller
@ComponentScan({"dbService", "validation"})
@Data
@NoArgsConstructor
public class MainController {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BuyingOperationService buyingOperationService;

    @GetMapping({REGISTRATION_URL})
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(REGISTRATION_URL, VIEW_USER, new ViewUser());
    }

    @Autowired
    @Qualifier(VIEW_USER_VALIDATOR)
    private Validator viewUserValidator;

    //Аннотация @Valid инициализирует проверку данных
    //В этом случае выполнится только spring проверка, декларативные проверки (типа @Null, @Email и тд) будут проигнорированы
    @PostMapping({REGISTER_URL})
    public String register(@Valid @ModelAttribute(VIEW_USER) ViewUser viewUser,
                           BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

        viewUserValidator.validate(viewUser, result);
        if (result.hasErrors()) {   //если есть ошибки
            showErrors(result, model);
            return REGISTRATION_URL;
        }

        String password = passwordEncoder.encode(viewUser.getPassword());
        viewUser.setPassword(password);
        viewUser.setRole(ROLE_USER);
        userService.save(viewUser);
        redirectAttributes.addFlashAttribute(VIEW_USER, viewUser);
        return "redirect:" + USER_PROFILE_URL;
    }

    @GetMapping({LOGIN_URL})
    public ModelAndView showLoginPage() {
        return new ModelAndView(LOGIN_URL);
    }

    //вывести сообщение об ошибке возле нужного поля
    private void showErrors(BindingResult result, ModelMap modelMap) {
        List<ObjectError> errorsList = result.getAllErrors();

        for (ObjectError objectError : errorsList) {
            FieldError fieldError = null;
            if (objectError instanceof FieldError) {
                fieldError = (FieldError) objectError;
                modelMap.addAttribute(fieldError.getField(), fieldError.getCode());
            }
        }
    }

    @GetMapping(SHOW_USERS_URL)
    public String showUsers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<ViewUser> users = userService.findAll();
        model.addAttribute(USERNAME, currentPrincipalName);
        model.addAttribute(USERS, users);
        return SHOW_USERS_URL;
    }

    @GetMapping(SHOW_BOOKS_URL)
    public String showBooks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if (currentPrincipalName.equals("anonymousUser")) {
            model.addAttribute(USERNAME, DEFAULT_USERNAME);
        } else {
            model.addAttribute(USERNAME, currentPrincipalName);
        }

        List<ViewBook> bookList = bookService.findAll();
        model.addAttribute(BOOKS, bookList);
        return SHOW_BOOKS_URL;
    }

    @GetMapping(USER_PROFILE_URL)
    public String showUserProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ViewUser viewUser = userService.findByLogin(currentPrincipalName);
        model.addAttribute(VIEW_USER, viewUser);
        return USER_PROFILE_URL;
    }

    @GetMapping(BUY_BOOK_URL)
    public String checkBuyingParams(@RequestParam(ACCOUNT_BOOK_ID) long bookId,
                                    @RequestParam(ACCOUNT_USERNAME) String userName, Model model) {
        ViewBook viewBook = bookService.findById(bookId);
        ViewUser viewUser = userService.findByLogin(userName);

        model.addAttribute(VIEW_USER, viewUser);
        model.addAttribute(VIEW_BOOK, viewBook);
        model.addAttribute(ACCOUNT_LOGIN, userName);
        model.addAttribute(VIEW_BUYING_OPERATION, new ViewBuyingOperation());
        return BUY_BOOK_URL;
    }

    @PostMapping(BUY_BOOK_URL)
    public String buyBook(@ModelAttribute(VIEW_BUYING_OPERATION) ViewBuyingOperation viewBuyingOperation,
                          RedirectAttributes redirectAttributes) {
        viewBuyingOperation.setDate(new Date());

        ViewBook viewBook = bookService.findById(viewBuyingOperation.getBookId());
        ViewUser viewUser = userService.findById(viewBuyingOperation.getUserId());
        viewUser.getBooks().add(viewBook);

        userService.save(viewUser);
        buyingOperationService.save(viewBuyingOperation);

        redirectAttributes.addFlashAttribute(VIEW_USER, viewUser);
        return "redirect:" + USER_PROFILE_URL;
    }

    @GetMapping({BOOK_INFO_URL})
    public String showBookInfo(@RequestParam(ACCOUNT_BOOK_ID) long bookId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if (currentPrincipalName.equals("anonymousUser")) {
            model.addAttribute(USERNAME, DEFAULT_USERNAME);
        } else {
            model.addAttribute(USERNAME, currentPrincipalName);
        }
        ViewBook viewBook = bookService.findById(bookId);
        model.addAttribute(VIEW_BOOK, viewBook);
        return BOOK_INFO_URL;
    }

    @GetMapping({ADMIN_PAGE_URL})
    public ModelAndView showAdminPage() {
        return new ModelAndView(ADMIN_PAGE_URL);
    }

    @GetMapping({ADD_BOOK_URL})
    public String showAddingBookPage(Model model) {
        model.addAttribute(VIEW_BOOK, new ViewBook());
        return ADD_BOOK_URL;
    }

    @Autowired
    @Qualifier(VIEW_BOOK_VALIDATOR)
    private Validator viewBookValidator;

    //Аннотация @Valid инициализирует проверку данных
    //В этом случае выполнится только spring проверка, декларативные проверки (типа @Null, @Email и тд) будут проигнорированы
    @PostMapping({ADD_BOOK_URL})
    public String addBook(@Valid @ModelAttribute(VIEW_BOOK) ViewBook viewBook,
                          BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        viewBookValidator.validate(viewBook, result);
        if (result.hasErrors()) {   //если есть ошибки
            showErrors(result, model);
            return ADD_BOOK_URL;
        }

        bookService.save(viewBook);
        redirectAttributes.addFlashAttribute(VIEW_BOOK, viewBook);
        return "redirect:" + SHOW_BOOKS_URL;
    }

    @GetMapping(SHOW_OPERATIONS_URL)
    public String showOperations(Model model) {
        List<ViewBuyingOperation> operations = buyingOperationService.findAll();
        model.addAttribute(OPERATIONS, operations);
        return SHOW_OPERATIONS_URL;
    }

    @PostMapping(DELETE_OPERATION_URL)
    public String deleteOperation(@RequestParam(OPERATION_ID) long id) {
        ViewBuyingOperation viewBuyingOperation = buyingOperationService.findById(id);
        ViewUser viewUser = userService.findById(viewBuyingOperation.getUserId());
        ViewBook viewBook = bookService.findById(viewBuyingOperation.getBookId());
        viewUser.getBooks().remove(viewBook);
        userService.save(viewUser);

        buyingOperationService.deleteById(id);
        return "redirect:" + SHOW_OPERATIONS_URL;
    }
}