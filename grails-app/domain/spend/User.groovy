package spend

import org.apache.tools.ant.taskdefs.SQLExec

class User {

    String name
    static hasMany = [transactions: Transaction]
    static constraints = {
    }
}

class Transaction {

    int balance
    int expense
    String date

    static belongsTo = [user : User]
    static constraints = {
    }
}

class Expense {
    User user
    Transaction transaction
    static constraints = {
    }
}