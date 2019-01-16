package validation;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import viewModels.UserAccount;

import static viewModels.UIConstants.UserAccountAttributes.ACCOUNT_LOGIN;
import static viewModels.UIConstants.UserAccountAttributes.ACCOUNT_PASSWORD;
import static viewModels.UIConstants.UserAccountErrors.NO_LOGIN_ERROR;
import static viewModels.UIConstants.UserAccountErrors.NO_PASSWORD_ERROR;

@Service
@NoArgsConstructor
public class UserAccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserAccount.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserAccount userAccount = (UserAccount) obj;

        if (userAccount.getLogin().isEmpty()) {
            errors.rejectValue(ACCOUNT_LOGIN, NO_LOGIN_ERROR);
        }
        if (userAccount.getPassword().isEmpty()) {
            errors.rejectValue(ACCOUNT_PASSWORD, NO_PASSWORD_ERROR);
        }
    }
}
