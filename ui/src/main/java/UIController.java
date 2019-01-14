import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import viewModels.ViewUser;

import javax.validation.Valid;

@Controller
@Data
@NoArgsConstructor
public class UIController {

    @GetMapping({"/registration"})
    public ModelAndView showRegistrationPage() {
        return new ModelAndView("/registration", "viewUser", new ViewUser());
    }

    //объявление spring validator
    @Autowired
    @Qualifier("viewUserValidator")
    private Validator viewUserValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(viewUserValidator);
    }

    //Аннотация @Valid инициализирует проверку данных
    //В этом случае выполнится только spring проверка, декларативные проверки (типа @Null, @Email и тд) будут проигнорированы
    @PostMapping({"/register"})
    public String register(@Valid @ModelAttribute("viewUser") ViewUser viewUser,
                           BindingResult result, ModelMap model) {
        //если есть ошибки - вывести поле и сообщение
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            model.addAttribute("errorMessage",
                    "error in " + fieldError.getField() + ": " + fieldError.getCode());
            return "/registration";
        }

        model.addAttribute("firstName", viewUser.getFirstName());
        model.addAttribute("lastName", viewUser.getLastName());
        model.addAttribute("address", viewUser.getAddress());
        model.addAttribute("login", viewUser.getLogin());
        model.addAttribute("password", viewUser.getPassword());

        System.out.println(viewUser);
        return "/userProfile";
    }
}
