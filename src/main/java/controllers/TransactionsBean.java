package controllers;

import dao.TransactionDAO;
import models.Transaction;
import models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("transaction")
@SessionScoped
public class TransactionsBean implements Serializable {

    public static List<Transaction> transactions=new ArrayList<Transaction>();
    public static boolean viewTransactions;


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        TransactionsBean.transactions = transactions;
    }

    public boolean isViewTransactions() {
        return viewTransactions;
    }

    public void setViewTransactions(boolean viewTransactions) {
        TransactionsBean.viewTransactions = viewTransactions;
    }

    public void showTransactions() {
        transactions.clear();
        User user = new PanelBean().getUser();

        List <Transaction> tmp = new TransactionDAO().getTransactions();

        for (Transaction t: tmp) {
            if(t.getUser_id() == user.getId()) {
                transactions.add(t);
            }
        }
        viewTransactions=true;

    }
}
