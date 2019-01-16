import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
import viewModels.ViewUser;

import javax.validation.Valid;
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
}
