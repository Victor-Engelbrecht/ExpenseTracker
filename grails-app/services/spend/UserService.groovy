package spend

import grails.gorm.services.Service
import org.apache.tools.ant.taskdefs.SQLExec



@Service(User)
interface UserService {

    User get(Serializable id)

    List<User> list(Map args)

    Long count()

    void delete(Serializable id)

    User save(User user)

}

@Service(Transaction)
interface TransactionService {

    Transaction get(Serializable id)

    List<Transaction> list(Map args)

    Long count()

    void delete(Serializable id)

    Transaction save(Transaction transaction)

}

@Service(Expense)
interface ExpenseService {

    Expense get(Serializable id)

    List<Expense> list(Map args)

    Long count()

    void delete(Serializable id)

    Expense save(Expense expense)

}