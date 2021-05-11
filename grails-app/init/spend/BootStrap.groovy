package spend

import org.apache.tools.ant.taskdefs.SQLExec

class BootStrap {
    UserService userService
    TransactionService transactionService
    def init = { servletContext ->
        new User(name:'victor').addToTransactions(new Transaction(balance:1000,expense: 500,date: new Date()))
                .addToTransactions(new Transaction(balance:500,expense: 300,date: new Date()))
                .addToTransactions(new Transaction(balance:200,expense: 0,date: new Date()))
                .save()
        new User(name:'josh').addToTransactions(new Transaction(balance:5000,expense: 500,date: new Date()))
                .addToTransactions(new Transaction(balance:4500,expense: 300,date: new Date()))
                .addToTransactions(new Transaction(balance:4200,expense: 0,date: new Date()))
                .save()
    }
    def destroy = {
    }
}
