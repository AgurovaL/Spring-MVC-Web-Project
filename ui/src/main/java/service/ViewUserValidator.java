package service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import viewModels.ViewUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class ViewUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ViewUser.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ViewUser user = (ViewUser) obj;

        Pattern spacePattern = Pattern.compile("^\\w+[ +\\w+]$");  //строка не из пробелов
        Pattern onlyDigitPattern = Pattern.compile(".*[0-9].*$");  //строка из чисел
        Pattern digitsAndLettersPatter = Pattern.compile("^([a-zа-яё]+|\\d+)$");

        Matcher spaceMatcher = spacePattern.matcher(user.getFirstName());
        Matcher onlyDigitsMatcher = onlyDigitPattern.matcher(user.getFirstName());
        if (user.getFirstName().length() < 2) {
            errors.rejectValue("firstName", "short name");
        }
        if (user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "empty name");
        }
        if (!spaceMatcher.matches() || onlyDigitsMatcher.matches()) {
            errors.rejectValue("firstName", "must contain only letters");
        }

        spaceMatcher = spacePattern.matcher(user.getLastName());
        if (user.getLastName().length() < 2) {
            errors.rejectValue("lastName", "short last name");
        }
        if (!spaceMatcher.matches() || onlyDigitsMatcher.matches()) {
            errors.rejectValue("lastName", "must contain only letters");
        }

        spaceMatcher = spacePattern.matcher(user.getAddress());
        if (user.getAddress().isEmpty()) {
            errors.rejectValue("address", "empty address");
        }
        if (!spaceMatcher.matches()) {
            errors.rejectValue("address", "must contain only letters and digits");
        }

        spaceMatcher = spacePattern.matcher(user.getLogin());
        if (user.getLogin().length() < 4) {
            errors.rejectValue("login", "short login");
        }
        if (!spaceMatcher.matches()) {
            errors.rejectValue("login", "must contain only letters and digits");
        }

        spaceMatcher = spacePattern.matcher(user.getPassword());
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "short password");
        }
        Matcher digitsAndLettersMatcher = digitsAndLettersPatter.matcher(user.getPassword());
        if (!spaceMatcher.matches() || digitsAndLettersMatcher.matches()) {
            errors.rejectValue("password", "not save; must contain both letters and digits");
        }
        if (!user.getPassword().equals(user.getPassword2())) {
            errors.rejectValue("password", "passwords not equal");
        }
    }
}
