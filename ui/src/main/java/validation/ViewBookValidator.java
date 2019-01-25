package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import viewModels.ViewBook;

import static viewModels.UIConstants.AttributesSizes.MIN_NUMBER_VALUE;
import static viewModels.UIConstants.AttributesSizes.MIN_YEAR_OF_PUBLISHING;
import static viewModels.UIConstants.ViewBookAttributes.*;
import static viewModels.UIConstants.ViewBookErrors.*;

public class ViewBookValidator implements Validator {
    private ViewBook book;
    private Errors errors;

    @Override
    public boolean supports(Class<?> aClass) {
        return ViewBook.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        this.book = (ViewBook) obj;
        this.errors = errors;

        validateTitle();
        validateAuthor();
        validatePublisher();
        validateYearOfWriting();
        validateYearOfPublishing();
        validatePagesNumber();
        validatePrice();
    }

    private void validateTitle() {
        String title = book.getTitle();
        if (title.isEmpty()) {
            errors.rejectValue(TITLE, NO_TITLE);
        }
    }


    private void validateAuthor() {
        String author = book.getAuthor();
        if (author.isEmpty()) {
            errors.rejectValue(AUTHOR, NO_AUTHOR);
        }
    }

    private void validatePublisher() {
        String publisher = book.getPublisher();
        if (publisher.isEmpty()) {
            errors.rejectValue(PUBLISHER, NO_PUBLISHER);
        }
    }

    private void validateYearOfWriting() {
        int yearOfWriting = book.getYearOfWriting();
        if (yearOfWriting <= MIN_NUMBER_VALUE) {
            errors.rejectValue(YEAR_OF_WRITING, NO_YEAR_OF_WRITING);
        }
    }

    private void validateYearOfPublishing() {
        int yearOfPublishing = book.getYearOfPublishing();
        if (yearOfPublishing <= MIN_YEAR_OF_PUBLISHING) {
            errors.rejectValue(YEAR_OF_PUBLISHING, NO_YEAR_OF_PUBLISHING);
        }
    }

    private void validatePagesNumber() {
        int pagesNumber = book.getPagesNumber();
        if (pagesNumber <= MIN_NUMBER_VALUE) {
            errors.rejectValue(PAGES_NUMBER, NO_PAGES_NUMBER);
        }
    }

    private void validatePrice() {
        int price = book.getPrice();
        if (price <= MIN_NUMBER_VALUE) {
            errors.rejectValue(PRICE, NO_PRICE);
        }
    }
}
