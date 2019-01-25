package validation;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import viewModels.ViewUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static viewModels.UIConstants.RegexPatterns.*;
import static viewModels.UIConstants.AttributesSizes.NAME_MIN_LENGTH;
import static viewModels.UIConstants.AttributesSizes.PASSWORD_MIN_LENGTH;
import static viewModels.UIConstants.ViewUserAttributes.*;
import static viewModels.UIConstants.ViewUserErrors.*;

@Service
@NoArgsConstructor
public class ViewUserValidator implements Validator {
    private final Pattern spacePattern = Pattern.compile(SPACE_PATTERN);  //строка не из пробелов
    private final Pattern onlyDigitPattern = Pattern.compile(ONLY_DIGIT_PATTERN);  //строка из чисел
    private final Pattern digitsAndLettersPattern = Pattern.compile(DIGITS_LETTERS_PATTERN);
    private Matcher spaceMatcher;
    private ViewUser user;
    private Errors errors;

    @Override
    public boolean supports(Class<?> aClass) {
        return ViewUser.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        this.user = (ViewUser) obj;
        this.errors = errors;

        validateName();
        validateAddress();
        validateLogin();
        validatePassword();
    }

    private void validateName() {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        spaceMatcher = spacePattern.matcher(firstName);
        Matcher onlyDigitsMatcher = onlyDigitPattern.matcher(firstName);
        if (firstName.isEmpty()) {
            errors.rejectValue(FIRST_NAME, NO_NAME);
        } else {
            if (firstName.length() < NAME_MIN_LENGTH) {
                errors.rejectValue(FIRST_NAME, SHORT_NAME);
            } else {
                if (!spaceMatcher.matches() || onlyDigitsMatcher.matches()) {
                    errors.rejectValue(FIRST_NAME, WRONG_NAME);
                }
            }
        }

        spaceMatcher = spacePattern.matcher(lastName);
        if (!lastName.isEmpty() && (!spaceMatcher.matches() || onlyDigitsMatcher.matches())) {
            errors.rejectValue(LAST_NAME, WRONG_NAME);
        }
    }

    private void validateAddress() {
        String address = user.getAddress();

        spaceMatcher = spacePattern.matcher(address);
        if (address.isEmpty()) {
            errors.rejectValue(ADDRESS, NO_ADDRESS);
        } else {
            if (!spaceMatcher.matches()) {
                errors.rejectValue(ADDRESS, WRONG_ADDRESS);
            }
        }
    }

    private void validateLogin() {
        String login = user.getLogin();

        spaceMatcher = spacePattern.matcher(login);
        if (login.isEmpty()) {
            errors.rejectValue(VIEW_LOGIN, NO_LOGIN);
        } else {
            if (login.equalsIgnoreCase(ADMIN_VIEW_LOGIN)) {
                errors.rejectValue(VIEW_LOGIN, FORBIDDEN_LOGIN);
            } else {
                if (login.length() < NAME_MIN_LENGTH) {
                    errors.rejectValue(VIEW_LOGIN, SHORT_LOGIN);
                } else {
                    if (!spaceMatcher.matches()) {
                        errors.rejectValue(VIEW_LOGIN, WRONG_LOGIN);
                    }
                }
            }
        }
    }

    private void validatePassword() {
        String password = user.getPassword();

        spaceMatcher = spacePattern.matcher(password);
        if (password.isEmpty()) {
            errors.rejectValue(VIEW_PASSWORD, NO_PASSWORD);
        } else {
            if (password.length() < PASSWORD_MIN_LENGTH) {
                errors.rejectValue(VIEW_PASSWORD, SHORT_PASSWORD);
            } else {
                Matcher digitsAndLettersMatcher = digitsAndLettersPattern.matcher(password);
                if (!spaceMatcher.matches() || digitsAndLettersMatcher.matches()) {
                    errors.rejectValue(VIEW_PASSWORD, WRONG_PASSWORD);
                } else {
                    if (!password.equals(user.getPassword2())) {
                        errors.rejectValue(VIEW_PASSWORD2, NOT_EQUAL);
                    }
                }
            }
        }
    }
}
