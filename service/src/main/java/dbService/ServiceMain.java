package dbService;
/*
get access to data base from DAL module
 */

import dbActions.DBService;

public class ServiceMain {

    public static void main(String[] args) {
        DBService dbService = DBService.config();

        dbService.saveBooks();
    }
}