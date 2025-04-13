package ruwanpathiranatc.LKBANK.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;
    private String currency;
    private char symbol;
    private String code;
    private String accountName;
    @Column(nullable = false, unique = true)
    private long accountNumber;
    private double balance;
    private String label;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> transactions;

    public Account(String accountId, String currency, char symbol, String code, String accountName, long accountNumber, double balance, String label, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.accountId = accountId;
        this.currency = currency;
        this.symbol = symbol;
        this.code = code;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.label = label;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Account() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
