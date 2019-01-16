package viewModels;

public interface UIConstants {
    interface ViewUserAttributes {
        String VIEW_USER = "viewUser";
        String USER_ACCOUNT_VALIDATOR = "userAccountValidator";

        String ID = "id";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String ADDRESS = "address";
        String VIEW_LOGIN = "login";
        String VIEW_PASSWORD = "password";
        String VIEW_PASSWORD2 = "password2";
    }

    interface UserAccountAttributes {
        String USER_ACCOUNT = "userAccount";
        String VIEW_USER_VALIDATOR = "viewUserValidator";

        String ACCOUNT_LOGIN = "login";
        String ACCOUNT_PASSWORD = "password";
    }

    interface ViewUserErrors {
        String NO_NAME = "enter name";
        String SHORT_NAME = "too short name";
        String WRONG_NAME = "must contain only letters";

        String NO_ADDRESS = "enter address";
        String WRONG_ADDRESS = "must contain only letters and digits";

        String NO_LOGIN = "enter login";
        String SHORT_LOGIN = "too short login";
        String WRONG_LOGIN = "must contain only letters and digits";

        String NO_PASSWORD = "enter password";
        String SHORT_PASSWORD = "too short password";
        String WRONG_PASSWORD = "not save: must contain both letters and digits";
        String NOT_EQUAL = "passwords not equal";

    }

    interface UserAccountErrors {
        String NO_LOGIN_ERROR = "enter login";
        String NO_PASSWORD_ERROR = "enter password";
    }

    interface RegexPatterns {
        String SPACE_PATTERN = "^\\w+[ +\\w+]$";
        String ONLY_DIGIT_PATTERN = ".*[0-9].*$";
        String DIGITS_LETTERS_PATTERN = "^([a-zа-яё]+|\\d+)$";
    }

    interface StringsSizes {
        int NAME_MIN_LENGTH = 2;
        int PASSWORD_MIN_LENGTH = 8;
    }

    interface PagesURLs {
        String REGISTRATION_URL = "/registration";
        String REGISTER_URL = "/register";
        String USER_PROFILE_URL = "/userProfile";
        String LOGIN_URL = "/login";
    }
}
