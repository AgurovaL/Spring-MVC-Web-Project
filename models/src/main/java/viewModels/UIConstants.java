package viewModels;

public interface UIConstants {
    interface PagesURLs {
        String REGISTRATION_URL = "/registration";
        String REGISTER_URL = "/register";
        String USER_PROFILE_URL = "/userProfile";
        String LOGIN_URL = "/signin";
        String SHOW_USERS_URL = "/showUsers";
        String SHOW_BOOKS_URL = "/showBooks";
        String BUY_BOOK_URL = "/buyBook";
        String BOOK_INFO_URL = "/bookInfo";
        String ADMIN_PAGE_URL = "/adminPage";
        String ADD_BOOK_URL = "/addBook";
        String SHOW_OPERATIONS_URL = "/showOperations";
        String DELETE_OPERATION_URL = "/deleteOperation";
    }

    interface Roles {
        String ROLE_ADMIN = "ROLE_ADMIN";
        String ROLE_USER = "ROLE_USER";
        String ROLE_GUST = "ROLE_GUEST";
    }

    interface ViewUserAttributes {
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String ADDRESS = "address";
        String VIEW_LOGIN = "login";
        String ADMIN_VIEW_LOGIN = "admin";
        String VIEW_PASSWORD = "password";
        String VIEW_PASSWORD2 = "password2";
    }

    interface UserAccountAttributes {
        String ACCOUNT_LOGIN = "username";
        String ACCOUNT_PASSWORD = "password";
    }

    interface OperationAttributes {
        String OPERATION_ID = "id";
        String ACCOUNT_USERNAME = "userName";
        String ACCOUNT_BOOK_ID = "bookId";
    }

    interface ViewBookAttributes {
        String TITLE = "title";
        String AUTHOR = "author";
        String PUBLISHER = "publisher";
        String YEAR_OF_WRITING = "yearOfWriting";
        String YEAR_OF_PUBLISHING = "yearOfPublishing";
        String PAGES_NUMBER = "pagesNumber";
        String PRICE = "price";
    }

    interface ModelAttributes {
        String VIEW_USER = "viewUser";
        String VIEW_USER_VALIDATOR = "viewUserValidator";

        String USER_ACCOUNT = "userAccount";
        String USER_ACCOUNT_VALIDATOR = "userAccountValidator";

        String USERS = "users";
        String BOOKS = "books";
        String OPERATIONS = "operations";

        String USERNAME = "username";
        String DEFAULT_USERNAME = "GUEST";

        String VIEW_BOOK = "viewBook";
        String VIEW_BOOK_VALIDATOR = "viewBookValidator";
        String VIEW_BUYING_OPERATION = "viewBuyingOperation";
    }

    interface ViewUserErrors {
        String NO_NAME = "enter name";
        String SHORT_NAME = "too short name";
        String WRONG_NAME = "must contain only letters";

        String NO_ADDRESS = "enter address";
        String WRONG_ADDRESS = "must contain only letters and digits";

        String NO_LOGIN = "enter login";
        String FORBIDDEN_LOGIN = "you can't register as admin";
        String SHORT_LOGIN = "too short login";
        String WRONG_LOGIN = "must contain only letters and digits";

        String NO_PASSWORD = "enter password";
        String SHORT_PASSWORD = "too short password";
        String WRONG_PASSWORD = "not save: must contain both letters and digits";
        String NOT_EQUAL = "passwords not equal";

    }

    interface ViewBookErrors {
        String NO_TITLE = "enter title";
        String NO_AUTHOR = "enter author";
        String NO_PUBLISHER = "enter publisher";
        String NO_YEAR_OF_WRITING = "enter year of writing";
        String NO_YEAR_OF_PUBLISHING = "enter year of publishing";
        String NO_PAGES_NUMBER = "enter number of pages";
        String NO_PRICE = "enter price";
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

    interface AttributesSizes {
        int NAME_MIN_LENGTH = 2;
        int PASSWORD_MIN_LENGTH = 8;
        int MIN_NUMBER_VALUE = 0;
        int MIN_YEAR_OF_PUBLISHING = 1800;
    }
}
